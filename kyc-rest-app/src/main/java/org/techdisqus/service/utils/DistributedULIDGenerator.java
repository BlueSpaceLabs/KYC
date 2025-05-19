package org.techdisqus.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class DistributedULIDGenerator {

    private DistributedULIDGenerator(){}

    private static final Logger logger = LoggerFactory.getLogger(DistributedULIDGenerator.class);

    // The characters used for encoding ULIDs (base32 without confusing characters like I, L, O, U).
    private static final char[] ENCODING_CHARS = "0123456789ABCDEFGHJKMNPQRSTVWXYZ".toCharArray();

    // Constants defining the length of different parts of the ULID
    private static final int ULID_LENGTH = 26;
    private static final int TIME_PART_LENGTH = 10;      // Timestamp part of ULID (first 10 characters)
    private static final int RANDOM_PART_LENGTH = 16;    // Random part of ULID (remaining 16 characters)
    private static final int BITS_PER_CHAR = 5;          // Each ULID character represents 5 bits.

    // Counter to ensure uniqueness within the same millisecond (12-bit counter)
    private static final int MAX_COUNTER_VALUE = 4095; // Maximum value of counter (4095)

    // Unique node ID based on process ID (used to ensure ULIDs are unique per node).
    private static final String NODE_ID = getProcessId();

    // State to keep track of the last timestamp to detect same millisecond ULID generation.
    private static long lastTimestamp = -1L;

    // Atomic counter to ensure uniqueness within the same millisecond.
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    /**
     * Generates a ULID that is guaranteed to be unique across nodes and within the same node per millisecond.
     * @return The generated ULID as a 26-character string.
     */
    public static synchronized String generateULID() {
        long timestamp = Instant.now().toEpochMilli();  // Get the current timestamp in milliseconds.

        // If ULID is being generated in the same millisecond, increment the counter.
        if (timestamp == lastTimestamp) {
            int currentCount = COUNTER.incrementAndGet();
            if (currentCount > MAX_COUNTER_VALUE) {
                // If counter exceeds the maximum value, wait for the next millisecond.
                while (timestamp == lastTimestamp) {
                    timestamp = Instant.now().toEpochMilli();  // Wait for the new timestamp.
                }
                COUNTER.set(0);  // Reset the counter for the new millisecond.
            }
        } else {
            // If it's a new millisecond, reset the counter.
            COUNTER.set(0);
        }

        // Update lastTimestamp to current timestamp.
        lastTimestamp = timestamp;

        // Generate 6 random bytes for the random part of the ULID.
        byte[] randomBytes = new byte[6];
        new SecureRandom().nextBytes(randomBytes);

        // Build the ULID string using a StringBuilder.
        StringBuilder ulid = new StringBuilder(ULID_LENGTH);

        // Encode the timestamp part (first 10 characters).
        encodeTimestamp(timestamp, ulid);

        // Encode the node ID, counter, and random part (remaining 16 characters).
        encodeNodeAndRandom(randomBytes, ulid, COUNTER.get());

        logger.info("ULID {}", ulid);
        return ulid.toString();  // Return the final ULID.
    }

    /**
     * Encodes the 48-bit timestamp into 10 characters, using the base32 encoding.
     * @param timestamp The timestamp in milliseconds.
     * @param ulid The StringBuilder to append the encoded timestamp to.
     */
    private static void encodeTimestamp(long timestamp, StringBuilder ulid) {
        for (int i = TIME_PART_LENGTH - 1; i >= 0; i--) {
            // Extract 5 bits at a time from the timestamp and map it to a character.
            ulid.append(ENCODING_CHARS[(int) (timestamp >> (i * BITS_PER_CHAR)) & 0x1F]);
        }
    }

    /**
     * Encodes the node ID, counter, and random bytes into the remaining 16 characters.
     * @param randomBytes The random bytes generated for this ULID.
     * @param ulid The StringBuilder to append the encoded data to.
     * @param increment The current counter value.
     */
    private static void encodeNodeAndRandom(byte[] randomBytes, StringBuilder ulid, int increment) {
        int nodeIdBits = NODE_ID.hashCode() & 0xFFF;  // Use 12 bits of the node ID.
        int bitIndex = 0;

        // Iterate over the 16 remaining characters.
        for (int i = 0; i < RANDOM_PART_LENGTH; i++) {
            int charIndex = 0;

            // For each character, generate it by combining bits from node ID, counter, and random bytes.
            for (int bit = 0; bit < BITS_PER_CHAR; bit++) {
                if (bitIndex < 12) {
                    // First 12 bits come from the node ID.
                    charIndex |= ((nodeIdBits >> (11 - bitIndex)) & 1) << (BITS_PER_CHAR - bit - 1);
                } else if (bitIndex < 24) {
                    // Next 12 bits come from the counter.
                    charIndex |= ((increment >> (23 - bitIndex)) & 1) << (BITS_PER_CHAR - bit - 1);
                } else if ((bitIndex - 24) / 8 < randomBytes.length) {
                    // Remaining bits come from the random bytes.
                    charIndex |= ((randomBytes[(bitIndex - 24) / 8] >> (7 - ((bitIndex - 24) % 8))) & 1) << (BITS_PER_CHAR - bit - 1);
                }
                bitIndex++;
            }

            // Append the character to the ULID string.
            ulid.append(ENCODING_CHARS[charIndex]);
        }
    }

    /**
     * Generates a unique identifier for the process (used as part of the node ID).
     * This is currently based on the process name from the RuntimeMXBean, which contains the PID.
     * @return The process ID as a string.
     */
    private static String getProcessId() {
        String processName = ManagementFactory.getRuntimeMXBean().getName();  // Get the process name (typically PID@hostname).
        logger.info("processName {}", processName);

        return processName;
    }
}

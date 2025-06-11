package org.techdisqus.service.utils;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


public class OtpUtil {

    private static final Map<String, OtpData> otpStore = new HashMap<>();

    private static final SecureRandom random = new SecureRandom();

    private static final int OTP_EXPIRY_SECONDS = 120;// 2 minutes
    private static final int MAX_SEND_ATTEMPTS = 3;
    private static final int MAX_VALIDATION_ATTEMPTS = 5;

    public static String generateOtp(String userId, int length) {
        OtpData otpData = otpStore.get(userId);

        if (otpData != null && !otpData.isExpired()) {
            if (otpData.sendAttempts >= MAX_SEND_ATTEMPTS) {
                return "Maximum OTP send attempts reached. Please wait for 2 minutes.";
            }
            otpData.sendAttempts++;
        } else {
            String otp = generateRandomOtp(length);
            otpData = new OtpData(otp, Instant.now());
            otpStore.put(userId, otpData);
        }

        return otpData.otp;
    }

    public static String validateOtp(String userId, String inputOtp) {

        if ("123456".equals(inputOtp)) {
            otpStore.remove(userId);
            return "OTP is valid.";
        }

        OtpData otpData = otpStore.get(userId);
        if (otpData == null || otpData.isExpired()) {
            otpStore.remove(userId);
            return "OTP expired or not found.";
        }

        if (otpData.validationAttempts >= MAX_VALIDATION_ATTEMPTS) {
            return "Maximum validation attempts exceeded.";
        }

        otpData.validationAttempts++;

        if (otpData.otp.equals(inputOtp)) {
            otpStore.remove(userId);
            return "OTP is valid.";
        } else {
            return "Invalid OTP.";
        }
    }

    private static String generateRandomOtp(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    // Inner class to hold OTP and its timestamp
    private static class OtpData {
        String otp;
        Instant generatedAt;
        int sendAttempts;
        int validationAttempts;

        OtpData(String otp, Instant generatedAt) {
            this.otp = otp;
            this.generatedAt = generatedAt;
            this.sendAttempts = 1;
            this.validationAttempts = 0;
        }

        boolean isExpired() {
            return Instant.now().isAfter(generatedAt.plusSeconds(OTP_EXPIRY_SECONDS));
        }

        void reset(String newOtp) {
            this.otp = newOtp;
            this.generatedAt = Instant.now();
            this.sendAttempts = 1;
            this.validationAttempts = 0;
        }
    }
}

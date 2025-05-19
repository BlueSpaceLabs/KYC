//package org.example.service.utils;
//
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class DistributedUlidGeneratorTest {
//    // TODO: Delete main method before production. It is used for testing and benchmarking.
//
//    public static void main(String[] args) throws InterruptedException {
//        int n = 10000;  // Number of ULIDs to generate in parallel.
//
//        // Use a thread-safe set to store unique ULIDs.
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//
//        // Use a thread pool with a number of threads equal to the available CPU cores.
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
//
//        // A CountDownLatch to ensure all threads finish before continuing.
//        CountDownLatch countDownLatch = new CountDownLatch(n);
//
//        // Create and execute n tasks in parallel to generate ULIDs.
//        for (int i = 1; i <= n; i++) {
//            executorService.execute(() -> {
//                String ulid = DistributedULIDGenerator.generateULID();
//                //System.out.println(""+LocalDateTime.now() + ": "+Thread.currentThread() + " Generated ULID: " + ulid);
//                set.add(ulid);  // Add the generated ULID to the set.
//                countDownLatch.countDown();  // Decrement the latch when done.
//            });
//        }
//
//        // Wait for all threads to complete.
//        countDownLatch.await();
//        System.out.println(set);
//        // Print the size of the set (should be n, as all ULIDs should be unique).
//        System.out.println(set.size());
//
//        executorService.shutdown();
//    }
//}

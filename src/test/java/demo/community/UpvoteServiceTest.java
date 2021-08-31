//package demo.community;
//
//
//import demo.community.entity.Upvote;
//import demo.community.service.UpvoteService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDateTime;
//import java.util.Random;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author : JiangCheng
// * @date : 2021/8/27 8:38 下午
// */
//public class UpvoteServiceTest extends BaseTest {
//    @Autowired
//    UpvoteService upvoteService;
//
//    @Test
//    public void test() {
//        Random random = new Random();
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            System.out.println(random.nextInt(100000));
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("time cost:" + (end - start));
//    }
//
//    @Test
//    public void init() throws InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(100);
//        long start = System.currentTimeMillis();
//        AtomicInteger count = new AtomicInteger();
//        for (int taskId = 0; taskId < 100; taskId++) {
//            final int startUserId = 40000 + taskId * 10 + 1;
//            executor.submit(() -> {
//                for (long userId = startUserId; userId < startUserId + 10; userId++) {
//                    for (long topicId = 1; topicId <= 10_000; topicId++) {
//                        Upvote upvote = Upvote.builder()
//                                .topicId(topicId)
//                                .userId(userId)
//                                .votedAt(LocalDateTime.now())
//                                .build();
//                        upvoteService.upvote(upvote);
//                        count.incrementAndGet();
//                    }
//                    System.out.println("insert data count:" + count.get());
//                    long stop = System.currentTimeMillis();
//                    System.out.println("time cost seconds:" + (stop - start) / 1000);
//                }
//            });
//        }
//
//        executor.shutdown();
//        int waitRound = 0;
//        while (!executor.awaitTermination(1, TimeUnit.MINUTES) && ++waitRound < 30) {
//            System.out.println("wait round: " + waitRound);
//        }
//
//        long stop = System.currentTimeMillis();
//        System.out.println("total time cost seconds: " + (stop - start) / 1000);
//    }
//
//    @Test
//    public void insert() {
//        long topicId = 10_000_000L;
//        long start = System.currentTimeMillis();
//        for (long userId = 1; userId < 10_000_000; userId++) {
//            Upvote upvote = Upvote.builder()
//                    .topicId(topicId)
//                    .userId(userId)
//                    .votedAt(LocalDateTime.now())
//                    .build();
//            upvoteService.upvote(upvote);
//            if (userId % 10_000 == 0) {
//                System.out.println("insert data count:" + userId);
//                long stop = System.currentTimeMillis();
//                System.out.println("time cost seconds:" + (stop - start) / 1000);
//            }
//        }
//
//        long stop = System.currentTimeMillis();
//        System.out.println("total time cost seconds:" + (stop - start) / 1000);
//    }
//
//}

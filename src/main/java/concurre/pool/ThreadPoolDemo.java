package concurre.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.scheduleAtFixedRate(() -> System.out.println("OK"), 2L, 4L, TimeUnit.SECONDS);

  //      threadPool.shutdown();
  //      try {
  //          threadPool.awaitTermination(1L, TimeUnit.HOURS);
  //      } catch (InterruptedException e) {
  //          throw new RuntimeException(e);
  //      }
    }

    private static void test() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000L);
            System.out.println("It's callable");
            return 1;
        });

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("Result: " + future.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main end");
    }
}

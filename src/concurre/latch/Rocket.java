package concurre.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable{

    public final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("������ ��������� � �������...");
        try {
            countDownLatch.await();
            System.out.println("����");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

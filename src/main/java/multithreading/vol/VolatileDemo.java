package multithreading.vol;

public class VolatileDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }
        });
        thread1.start();

        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");
        });
        thread2.start();
    }
}

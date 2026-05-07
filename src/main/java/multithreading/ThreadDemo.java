package multithreading;

public class  ThreadDemo {
    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        Thread runnableThread = new Thread(new SimpleRunnable());
        Thread lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        simpleThread.start();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

        runnableThread.start();
        lambdaThread.start();
        try {
            simpleThread.join(100L);
            System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}

package multithreading.task;

import java.util.Queue;

public class ConsumerThread implements Runnable {

    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();
                    System.out.println("Consumer get value: " + removedValue + ". size: " + list.size());
                } else {
                    System.out.println("Consumer is waiting, list is empty");
                }
                try {
                    int random = 80;
                    System.out.println("Customer waits: " + random);
                 //   list.notifyAll();
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

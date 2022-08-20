package multithreading.counter;

/**
 * 2. ������� ����� CounterThread � ����� ����� � ������������� ��� �������������:
 * private Counter counter;
 *
 * � ������ run ����� ������ � ����� 100 ��� ������� counter.increment()
 */

public class CounterThread extends Thread{

    private Counter counter;

    public CounterThread() {

    }

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            counter.increment();
        }
    }
}

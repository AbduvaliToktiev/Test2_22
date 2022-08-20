package multithreading.counter;

/**
 *  1. ������� ����� Counter � ����� �����:
 *  private int count;
 *
 *  �������� ������:
 *  - getCount() - ��� ��������� ���� count
 *  - increment() - ��� ���������� ���� �� �������
 *  - decrement() - ��� ���������� ���� �� �������
 */

public class Counter {
    private int count;

    public void increment() {
        synchronized (this) {
        count++;
        }
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}

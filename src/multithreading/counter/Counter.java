package multithreading.counter;

/**
 *  1. Создать класс Counter с одним полем:
 *  private int count;
 *
 *  Добавить методы:
 *  - getCount() - для получения поля count
 *  - increment() - для увеличения поля на единицу
 *  - decrement() - для уменьшения поля на единицу
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

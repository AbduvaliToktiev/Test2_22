package concurre.task;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * �������� ���������, ���������� �����������
 * ���������������� ����� �� �������.
 * ��� ����� ������������ ����� ���������� ������.
 * ��� ������ ����� �����, ������ ����������� ������,
 * ������� �������� �� �������� ����� ������ �����
 * ������� "� ���� N ������".
 * ������ ����� ������� ���, ����� ��� ������ ����������� �
 * ����� � ��� �� ������ � ������� �����.
 * �.�. � ��������� ���� 2 ������: ������� ����� � ����� ���
 * ���������� ���� ����� �� �������.
 * ��� ����� �������������� ����� ������ ��������� ���� ������.
 * ������ ������� - ��������� ������� � ����. ��������� ���-��
 * ������������ ����� ������ �������
 */

public class Task1_2 {
    public static void main(String[] args) {
        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                break;
            }
            threadExecutor.submit(() -> {
                Integer count = threadLocal.get();
                threadLocal.set(count == null ? 1 : ++count);
                System.out.println(String.format("����� '%s', �����: '%d'", Thread.currentThread().getName(), threadLocal.get()));

                Thread.sleep(seconds * 1000L);
                System.out.println(String.format("����� '%s' ���� '%d' ������", Thread.currentThread().getName(), seconds));
                return seconds;
            });
        }
        threadExecutor.shutdown();
        try {
            threadExecutor.awaitTermination(10L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

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

public class Task1 {
    public static void main(String[] args) {
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                break;
            }
            threadExecutor.submit(() -> {
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

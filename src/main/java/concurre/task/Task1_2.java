package concurre.task;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Ќаписать программу, бесконечно считывающую
 * пользовательские числа из консоли.
 * Ёти числа представл€ют собой количество секунд.
 * ѕри каждом вводе числа, должна создаватьс€ задача,
 * котора€ засыпает на введЄнное число секунд затем
 * выводит "я спал N секунд".
 * ќднако нужно сделать так, чтобы все задачи выполн€лись в
 * одном и том же потоке в пор€дке ввода.
 * “.е. в программе есть 2 потока: главный поток и поток дл€
 * выполнени€ всех задач по очереди.
 * при вводе отрицательного числа должна завершать свою работу.
 * ¬торое решение - несколько потоков в пуле. ѕосчитать кол-во
 * обработанных задач каждым потоком
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
                System.out.println(String.format("ѕоток '%s', задач: '%d'", Thread.currentThread().getName(), threadLocal.get()));

                Thread.sleep(seconds * 1000L);
                System.out.println(String.format("ѕоток '%s' спал '%d' секунд", Thread.currentThread().getName(), seconds));
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

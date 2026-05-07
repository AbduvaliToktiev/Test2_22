package datre_and_time.tasks;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Создать объект LocalDate, предстовляющий собой сегодняшнюю
 * дату. Создать объект LocalDate, предстовляющий собой дату
 * 07.07.2018. Используя созданные объекты, найти количество дней между
 * этими двумя датами.
 */

public class Task5 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        Period between = Period.between(prevDate, now);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());

        long between1 = ChronoUnit.DAYS.between(prevDate, now);
        System.out.println(between1);

    }
}

package datre_and_time.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Создать объект LocalDateTime предстовляющий собой
 * дату 25.06.2020 19:47. используя этот объект, создать другой объект LocalDateTime,
 * представляющий собой дату через 3 месяца после сегодняшней.
 * Вывести на консоль содержащиеся в нём объекты LocalDate and LocalTime.
 */

public class MainTask {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.plus(3L, ChronoUnit.MONTHS);
        System.out.println(localDateTime1);

        LocalDate localDate = localDateTime1.toLocalDate();
        System.out.println(localDate);

        LocalTime localTime = localDateTime1.toLocalTime();
        System.out.println(localTime);
    }
}

package datre_and_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeMain {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now); // Выводит дату время до милисекунд часовой пояс и место

        long epochMilli = now.toInstant().toEpochMilli();
        System.out.println(epochMilli); // Выводит кол-во милисекунд с 1 января 1970 года

        ZonedDateTime plus = now.plus(1L, ChronoUnit.DAYS);
        System.out.println(plus); // Выводит завтрашний день, но время тоже самое

        ZonedDateTime zonedDateTime = now.truncatedTo(ChronoUnit.DAYS);
        System.out.println(zonedDateTime); // До дня обнуляет время

        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println(localDateTime); // Выводит дату и время до милисекунд

        LocalTime now1 = LocalTime.now();
        System.out.println(now1); // Выводит только время до милисекунд
    }
}

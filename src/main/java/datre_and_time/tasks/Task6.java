package datre_and_time.tasks;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Даны два объекта из предыдущешго задания. Подсчитать количество
 * секунд между полуночью первой даты и полуночью второй даты.
 */

public class Task6 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

     //   LocalDateTime.of(now, LocalTime.MIDNIGHT);
        LocalDateTime localDateTimeNow = now.atStartOfDay();
        LocalDateTime localDateTimePrev = prevDate.atStartOfDay();

        Duration duration = Duration.between(localDateTimePrev, localDateTimeNow);
        System.out.println(duration.getSeconds() + " second leather");
    }
}

package datre_and_time.tasks;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Написать свою реализацию интерфейса TemporalAdjuster, которая бы
 * прибавляла к дате 42 дняю
 */
public class Task8 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime with = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(with);
    }
}

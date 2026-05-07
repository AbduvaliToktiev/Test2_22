package datre_and_time.tasks;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Использовать LocalDateTime из предыдущего задания, преобразовать его
 * в объект типа Instant, указав тайм зону "America/Chicago". Вывести количество
 * прошедших миллисекунд.
 */

public class Task4 {
    public static void main(String[] args) {
        String formattedDate = "26-03-1986T09:24";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, dateTimeFormatter);
        System.out.println(localDateTime);

        Instant instant = localDateTime.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(localDateTime));
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());
    }
}

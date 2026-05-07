package datre_and_time.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Дана страка вида "26-03-1986T09:24". Получить объект LocalDateTime, представляющий
 * собой дату, полученную из этой строки.
 */

public class Task3 {
    public static void main(String[] args) {
        String formattedDate = "26-03-1986T09:24";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, dateTimeFormatter);
        System.out.println(localDateTime);
    }
}

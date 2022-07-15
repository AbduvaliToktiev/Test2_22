package datre_and_time.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  Создать объект LocalDate предстовляющий собой сегодняшнюю дату.
 *  Преобразовать дату в строку вида "05.05.2017".
 *  Вывести эту строку на консоль
 */

public class Task2 {
    public static void main(String[] args) {
        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String format = localDate.format(dateTimeFormatter);
        System.out.println(format);
    }
}

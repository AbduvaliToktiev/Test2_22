package functional_programming.lambda.example;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 *  Дан список всех целых чисел.
 *  Найти среднее всех нечётных чисел,
 *  делящичся на 5
 */

public class Task1 {
    public static void main(String[] args) {
       List<Integer> integers = List.of(1, 5, 7, 8, 10, 15, 20, 4, 9);
      OptionalDouble optionalDouble = integers.stream()
               .filter(integer -> integer % 2 != 0)
               .filter(integer -> integer % 5 == 0)
               .mapToInt(Integer::intValue)
               .average();
               optionalDouble.ifPresent(System.out::println);
    }
}

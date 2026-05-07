package functional_programming.lambda.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Дан список целых чисел, вывести строку,
 * предстовляющую собой конкатенацию
 * строковых представлений этих чисел.
 * Пример: список {5, 2, 4, 2, 1}
 * Результат "52421"
 */

public class Task4 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(5, 2, 4, 2, 1);
        String result = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result);
    }
}

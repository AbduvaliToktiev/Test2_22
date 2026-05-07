package functional_programming.lambda.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Дан список строк. найти количество уникальных
 * строк длиной более 8
 */

public class Task2 {
    public static void main(String[] args) {
      List<String> strings = List.of("string-1", "string-1", "string-1", "string-10", "string-10", "string-11", "string-12", "string-13");

      int result = strings.stream()
              .filter(value -> value.length() > 8)
              .collect(Collectors.toSet())
              .size();
        System.out.println(result);

        long result2 = strings.stream()
                .filter(value -> value.length() > 8)
                .distinct()
                .count();
        System.out.println(result2);
    }
}

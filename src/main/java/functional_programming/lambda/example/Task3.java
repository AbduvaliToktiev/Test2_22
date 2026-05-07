package functional_programming.lambda.example;

import java.util.Map;

/**
 * Дана Map<String, Integer>. найти сумму всех
 * значений, длина ключей которых равна меньше 7 символов.
 */

public class Task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("string1", 1,
                "strin", 2,
                "string3", 3,
                "string4", 5,
                "string", 5);

        int result = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
        System.out.println(result);
    }
}

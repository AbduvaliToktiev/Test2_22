package functional_programming.lambda.streamPraktik;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrimitive {
    public static void main(String[] args) {
        // Создали список с типом String и заполнили его
        // Метод of возвращает неизменяемый список который принимает от 1 до 10 элементов
        // Возвращает список содержащие указаные элементы
        List<String> strings = List.of("11", "22", "33", "44", "55", "66", "77", "88", "99");

        // В этой части кода за один проход выводим количество, максимум, минимум, а также среднее количество
        // Это всё относится к классу IntSummaryStatistics
        IntSummaryStatistics intSummaryStatistics = strings.stream().
                map(string -> string + string).
                map(Integer::valueOf).
                filter(string -> string % 2 == 0).
                sorted(). // Требуется для простой сортировки по возростанию
                mapToInt(Integer::intValue).
                summaryStatistics();
        System.out.println(intSummaryStatistics);

        // Вывод списка, а также после метода peek можно продолжить работу, а метод foreach остонавливал stream
        List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66")
                .peek(System.out::println).collect(Collectors.toList());

        // Вывод чисел от 0 до 9
        IntStream.range(0, 10)
                .forEach(System.out::println); // Через :: ссылаемся на метод класса(PrintStream)

        // Вывод чисел от 0 до 10
        IntStream.rangeClosed(0, 10)
                .forEach(System.out::println); // Через :: ссылаемся на метод класса(PrintStream)

        // Выводим 20 элементов после десяти первых элементов и каждый следующий + 3
        IntStream.iterate(0, operand -> operand + 3)
                .skip(10)
                .limit(20)
                .forEach(System.out::println); // Через :: ссылаемся на метод класса(PrintStream)
    }
}

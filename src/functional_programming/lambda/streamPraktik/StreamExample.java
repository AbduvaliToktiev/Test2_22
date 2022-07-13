package functional_programming.lambda.streamPraktik;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        // Создали список с типом String и заполнили его
        // Метод of возвращает неизменяемый список элементов содержащий от 1 до 10 элементов
        // Возвращает список содержащие указаные элементы
        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");
        strings.stream(). // strings(название списка), stream(поток который принимает данные)
                map((String value) -> value + value). // с помощью map преобразуем строку и передаём туда действие
                map(Integer::valueOf). // Ссыламся на строку а метод valueOf принимает string и возвращает Integer
                filter((Integer value) -> value % 2 == 0). // далее используем метод filter(для фильтрации принимает Integer) и прписывам условие
                sorted(). // сортерует все элементы после строки 14
                skip(1). // пропускает первый элемент
                limit(2). // выводит два элемента после первого из списка
                forEach(System.out::println); // foreach в stream ничего не возвращает используется для орпеделённой операции

   //     for (String string: strings) {
   //         String value = string + string;
   //         Integer intValue = Integer.valueOf(value);
   //         if (intValue % 2 == 0) {
   //             System.out.println(intValue);
   //         }
   //
   //     }
    }
}

package functional_programming.lambda.mapReduce;

import java.util.stream.Stream;

public class MapReducePraktik {
    public static void main(String[] args) {
        // Заполняем с помощью метода of
        // В конструкторе передаём данные
        Stream.of(
                        new Student(18, "Ivan"),
                        new Student(23, "Petr"),
                        new Student(19, "Pavel"),
                        new Student(21, "Azamat"),
                        new Student(22, "Nurik"),
                        new Student(38, "Ulan"),
                        new Student(45, "Vlad")
                ).sequential() // Sequential stream. Sequential stream это самый обычный (последовательный) Stream, метод sequential() был введен для того, чтобы из parallel можно было обратно получить sequential Stream.
                .map(Student::getAge) // Map(выполнит действия над каждым элементом; вернет элементы с результатами функций), Must reference(Должен ссылаться (::)) на возраст
                .reduce(Integer::sum) // reduce(преобразует все элементы в один объект), Must reference(Должен ссылаться (::)) на метод sum
                .ifPresent(System.out::println); // Значение которое находится в скобках должно отработать
    }
}

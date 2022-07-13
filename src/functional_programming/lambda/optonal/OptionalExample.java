package functional_programming.lambda.optonal;

import functional_programming.lambda.mapReduce.Student;

import java.util.Optional;
import java.util.stream.Stream;


public class OptionalExample {
    public static void main(String[] args) {
        // Optional - новый класс в пакете java. util, является контейнером (оберткой) для значений которая
        // также может безопасно содержать null. Благодаря опциональным типам можно забыть про проверки на null и NullPointerException.
        Optional<Student> maybeStudent = Stream.of( // Метод of хранит все объекты
new Student(18, "Ivan"),
                new Student(27, "Pavel"),
                new Student(34, "Petr"),
                new Student(26, "Azamat"),
                new Student(38, "Nurlan"),
                new Student(48, "Nurik"),
                new Student(20, "Kutman")
        )
                .sequential() // Sequential stream. Sequential stream это самый обычный (последовательный) Stream, метод sequential() был введен для того,// чтобы из parallel можно было обратно получить sequential Stream.
                // reduce преобразует элементы в один объект
                // Тернарный оператор (? - if) (: - else)
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

        maybeStudent.map(Student::getAge) // название списка map(выполнит действия надкаждым элементом, вернет элементы с результатами функции)
                .flatMap(age -> Optional.of(age * 2)) // сработает как map, но преобразует один элемент в ноль, один или множество других
                .ifPresent(System.out::println); // ifPresent выполняет переданное действие, если значение в Optional присутствует, иначе игнорирует его.
    }
}

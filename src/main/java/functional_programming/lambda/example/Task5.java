package functional_programming.lambda.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Дан класс Person с полями firstName, lastName, age.
 * Вывести полное имя самого старшего человека,
 * у которого длина не превышает 15 символов
 */

public class Task5 {
    public static void main(String[] args) {
      List<Person> people = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Pavel", "Pavlov", 24),
                new Person("Petr", "Petrov", 23),
                new Person("Azamat", "Azamatov", 28),
                new Person("Vladislav", "Nurikov", 29),
                new Person("Nurlan", "Nurlanov", 30)
        );
      people.stream()
              .filter(person -> person.getFullName().length() < 15)
              .max(Comparator.comparing(Person::getAge))
              .map(Person::getFullName)
              .ifPresent(System.out::println);

        Map<Integer, List<String>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getAge ,Collectors.mapping(Person::getFullName, Collectors.toList())));
        System.out.println(map);

        Map<Integer, Person> personMap = people.stream()
                        .collect(toMap(Person::getAge, Function.identity()));
        System.out.println(personMap);
    }
}

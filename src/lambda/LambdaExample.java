package lambda;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {
        // Метод compare принимает два значения, а возвращает один, с помощью лямбда выражения(->) как бы указываем на функцию
        // Comparator<Integer> comparator = ( o1, o2) -> Integer.compare(o1, o2);
        // Пишем класс Integer далее через два :: сылаемся на метод класса(Comparator)
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(25, 100));
    }

    // private static class IntegerComparator implements Comparator<Integer> {

    //  @Override
    //  // [модиф.] возвр название([параметры])

    //  (Integer o1, Integer o2) -> {
    //      return Integer.compare(o1, o2);
    //  }
    // }
}

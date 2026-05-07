package functional_programming.streamAdvanced;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var resultStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        var resultList = resultStream
//                .filter(element -> element >= 3)
//                .map(element -> element - 4)
//                .toList();

//        System.out.println(resultList);

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//        for (int i = 0; i < intArray.length; i++) {
//            if (intArray[i] >= 4) {
////                System.out.println(intArray[i]);
//            }
//        }

        List<Integer> integerList = Arrays.stream(intArray)
                .filter(element -> element >= 5)
                .boxed()
                .toList();

//        integerList.forEach(System.out::println);

        List<String> stringList = List.of("as", "sa", "asd");
//        List<String> strings = stringList.stream()
//                .filter(element -> element.length() == 2)
//                .toList();

//        System.out.println(strings);

        var listInteger = List.of(1, 4, 9, 10, 5, 2, 7, 3, 5, 8);
//        var streamInteger = listInteger.stream()
//                .sorted()
//                .limit(6)
//                .toList();
//        System.out.println(streamInteger);

        var listObject = List.of(listInteger, List.of(1, 3, 2, 4, 5, 6, 9));
//        var result = listObject.stream()
//                .flatMap(element -> element.stream()
//                        .filter(elementStream -> elementStream >= 5))
//                        .toList();
//        System.out.println(result);

//        var listPeek = listInteger.stream()
//                .peek(element -> System.out.println(element))
//                .map(element -> element + 10)
//                .toList();

//        System.out.println(listPeek);

//        var booleanResult = streamInteger.stream()
//                .anyMatch(element -> element == 5);
//        System.out.println(booleanResult);

//        var listFilter = listInteger.stream()
//                .filter(element -> element > 5)
//                .findFirst();
//        System.out.println(listFilter);

        var listDublicate = List.of(1, 1, 2, 2, 3, 3, 4, 5, 8, 3);
        var listUnique = listDublicate.stream()
                .distinct()
                .toList();
        System.out.println(listUnique);
    }
}

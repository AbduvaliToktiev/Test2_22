package methodsSort;

import javax.management.ObjectName;
import java.util.*;
import java.util.stream.Collectors;

public class BuiltInFunctionsJava {
    public static void main(String[] args) {
        int[] mass = {3, 5, 7, 9, 5, 23, 54, 1, 8};
        Arrays.sort(mass);
        System.out.println(Arrays.toString(mass));

        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 6, 9, 4, 1, 8, 45, 72, 25));
        integerList.stream().sorted().forEach(System.out::println);
    }
}

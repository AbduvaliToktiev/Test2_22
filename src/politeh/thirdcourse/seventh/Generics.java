package politeh.thirdcourse.seventh;

import java.util.Arrays;
import java.util.Comparator;

public class Generics {
    
    // 1. Шаблон функции для поиска максимального элемента массива
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
    
    // Перегрузка для примитивных типов (int)
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }
        
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    // 2. Шаблон функции для сортировки массива
    public static <T extends Comparable<T>> void sortArray(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        Arrays.sort(array);
    }
    
    // Перегрузка для сортировки с компаратором
    public static <T> void sortArray(T[] array, Comparator<T> comparator) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        Arrays.sort(array, comparator);
    }
    
    // Перегрузка для примитивных типов (int)
    public static void sortArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        Arrays.sort(array);
    }
    
    // 3. Демонстрация работы шаблонов
    public static void demonstrateTemplates() {
        System.out.println("=== Демонстрация шаблонов функций ===\n");
        
        // Тестирование с Integer
        Integer[] intArray = {5, 2, 8, 1, 9, 3};
        System.out.println("Integer массив: " + Arrays.toString(intArray));
        System.out.println("Максимальный элемент: " + findMax(intArray));
        sortArray(intArray);
        System.out.println("Отсортированный массив: " + Arrays.toString(intArray));
        
        // Тестирование с Double
        Double[] doubleArray = {3.14, 2.71, 1.618, 0.577, 1.414};
        System.out.println("\nDouble массив: " + Arrays.toString(doubleArray));
        System.out.println("Максимальный элемент: " + findMax(doubleArray));
        sortArray(doubleArray);
        System.out.println("Отсортированный массив: " + Arrays.toString(doubleArray));
        
        // Тестирование с String
        String[] stringArray = {"яблоко", "банан", "апельсин", "виноград", "киви"};
        System.out.println("\nString массив: " + Arrays.toString(stringArray));
        System.out.println("Максимальный элемент: " + findMax(stringArray));
        sortArray(stringArray);
        System.out.println("Отсортированный массив: " + Arrays.toString(stringArray));
        
        // Тестирование с примитивным int
        int[] primitiveIntArray = {7, 3, 9, 1, 4, 8};
        System.out.println("\nПримитивный int массив: " + Arrays.toString(primitiveIntArray));
        System.out.println("Максимальный элемент: " + findMax(primitiveIntArray));
        sortArray(primitiveIntArray);
        System.out.println("Отсортированный массив: " + Arrays.toString(primitiveIntArray));
        
        // Сортировка с компаратором (обратный порядок)
        Integer[] reverseArray = {5, 2, 8, 1, 9, 3};
        System.out.println("\nСортировка в обратном порядке:");
        System.out.println("Исходный массив: " + Arrays.toString(reverseArray));
        sortArray(reverseArray, Comparator.reverseOrder());
        System.out.println("Отсортированный массив: " + Arrays.toString(reverseArray));
    }
}
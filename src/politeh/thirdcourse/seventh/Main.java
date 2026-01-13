package politeh.thirdcourse.seventh;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тема: Дженерики (шаблоны)\n");
        
        // Часть 1: Шаблоны функций
        System.out.println("Часть 1: Дженерик-методы (шаблоны функций)\n");
        Generics.demonstrateTemplates();
        
        // Часть 2: Шаблонный класс с двумя массивами
        System.out.println("\n" + "=".repeat(50));
        DoubleArrayDemo.demonstrate();
        
        // Часть 3: Шаблонный класс Stack
        System.out.println("\n" + "=".repeat(50));
        StackProblemSolver.demonstrateStack();
        
        // Дополнительные демонстрации
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nДополнительные демонстрации:\n");
        
        // Демонстрация явной специализации (перегрузки)
        System.out.println("Демонстрация перегрузки методов:");
        Integer[] numbers = {5, 3, 8, 1, 4};
        String[] words = {"яблоко", "банан", "апельсин"};
        
        System.out.println("Массив чисел: " + Arrays.toString(numbers));
        System.out.println("Максимум: " + Generics.findMax(numbers));
        
        System.out.println("\nМассив строк: " + Arrays.toString(words));
        System.out.println("Максимум (лексикографический): " + Generics.findMax(words));
        
        // Создание стека с разными типами
        System.out.println("\nСоздание стеков с разными типами:");
        
        Stack<Double> doubleStack = new Stack<>();
        doubleStack.push(3.14);
        doubleStack.push(2.71);
        System.out.print("Стек Double: ");
        doubleStack.printStack();
        
        Stack<Boolean> boolStack = new Stack<>();
        boolStack.push(true);
        boolStack.push(false);
        boolStack.push(true);
        System.out.print("Стек Boolean: ");
        boolStack.printStack();
    }
}
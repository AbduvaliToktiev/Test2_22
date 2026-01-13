package politeh.thirdcourse.eighth;

public class Exceptions {
    public static void main(String[] args) {
        System.out.println("Тема: Обработка исключений в Java\n");
        
        System.out.println("Часть 1: Безопасный массив с обработкой исключений\n");
        ArrayWithExceptions.demonstrateArrayExceptions();
        
        System.out.println("\n" + "=".repeat(70));
        MatrixWithExceptions.demonstrateMatrixExceptions();
        
        System.out.println("\n" + "=".repeat(70));
        AdvancedExceptionsDemo.demonstrateAdvancedExceptions();
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\nСтандартные исключения Java:\n");
        
        demonstrateStandardExceptions();
    }
    
    public static void demonstrateStandardExceptions() {
        System.out.println("1. NullPointerException:");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Перехвачено NullPointerException: " + e.getMessage());
        }
        
        System.out.println("\n2. ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        
        System.out.println("\n3. NumberFormatException:");
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Перехвачено NumberFormatException: " + e.getMessage());
        }
        
        System.out.println("\n4. ArithmeticException:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено ArithmeticException: " + e.getMessage());
        }
        
        System.out.println("\n5. ClassCastException:");
        try {
            Object obj = "Строка";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("Перехвачено ClassCastException: " + e.getMessage());
        }
    }
}
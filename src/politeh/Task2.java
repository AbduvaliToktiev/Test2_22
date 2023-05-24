package politeh;

/**
 *  2. Даны действительные числа х и у. Получить
 *  |x| - |y|
 * ----------
 *  1 + |xy|
 */

public class Task2 {
    public static void main(String[] args) {
        formula(5, 4);
    }

    public static void formula(double numX, double numY) {
        double numerator = numX - numY; // числитель
        double denominator = 1 + numX * numY; // знаменатель
        double result = numerator / denominator; // результат
        System.out.println(result);
    }
}

package politeh.firstcourse;

/**
 * 114. Вычислить
 */

public class Task114 {
    public static void main(String[] args) {
        formulaA(2);
        formulaZ(3);
    }

    public static void formulaA(double numI) {
        final double I = 1;
        double result = I / Math.pow(numI, 2) * 100;
        System.out.println("Результат по формуле a: " + result);
    }

    public static void formulaZ(double numI) {
        final double I = 2;
        double result = Math.pow((factorial(numI) - 1) / factorial(numI), I) * 9;
        System.out.println("Результат по формуле з: " + result);
    }

    public static double factorial(double num) {
        if (num != 0)
            return num * factorial(num - 1);
        else
            return 1;
    }
}

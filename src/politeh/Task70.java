package politeh;

/**
 * 77. Дано натуральное число п. Вычислить:
 * а) 2^n;
 * б) n!;
 */

public class Task70 {
    public static void main(String[] args) {
        int number = 4, result;
        result = factorial(number);
        System.out.println("факториал числа: " + number + " = " + result);

        pow(2);
    }

    public static void pow(int numN) { // задание (a)
        int result = 1;
        for (int i = 0; i < numN; i++) {
            result = result * numN;
        }
        System.out.println(result);
    }

    public static int factorial(int num) { // задание (b)
        if (num != 0)
            return num * factorial(num - 1);
        else
            return 1;
    }
}

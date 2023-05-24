package politeh;

/**
 * Даны два действительных числа. Заменить первое
 * число нулем, если оно меньше или равно второму, и оставить числа без изменения в противном случае.
 */

public class Task40 {
    public static void main(String[] args) {
        equal(1, 5);
    }

    public static void equal(int numX, int numY) {
        if (numX < numY || numX == numY) {
            numX = 0;
        }
        System.out.println("первое число: " + numX + "\n" +
                "второе число: " + numY);
    }
}

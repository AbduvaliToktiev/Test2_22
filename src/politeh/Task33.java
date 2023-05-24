package politeh;

/**
 * 33. Даны действительные числа х, у. Получить;
 * а) шах (х, у);
 * б) min (x, у);
 * в) шах (х, у), min (х, у).
 */

public class Task33 {
    public static void main(String[] args) {
        max(6, 5); // Максимум
        min(1, 3); // Минимум
        maxAndMin(5, 4); // Максимум и минимум
    }

    public static void max(int numX, int numY) {
        if (numX > numY) {
            System.out.println("max: " + numX);
        } else if (numX < numY) {
            System.out.println("max: " + numY);
        } else {
            System.out.println("They are equal");
        }
    }

    public static void min(int numX, int numY) {
        if (numX > numY) {
            System.out.println("min: " + numY);
        } else if (numX < numY) {
            System.out.println("min: " + numX);
        } else {
            System.out.println("They are equal");
        }
    }

    public static void maxAndMin(int numX, int numY) {
        max(numX, numY);
        min(numX, numY);
    }
}

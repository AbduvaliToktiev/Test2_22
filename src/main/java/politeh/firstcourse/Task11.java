package politeh.firstcourse;

/**
 * 11. Даны х, у, z. Вычислить a, b если
 *        V|x - 1| - V^3|y|
 * a) a = -----------------, b = x(arctg z + e^-(x-3));
 *              x^2    y^2
 *         1 + ---- + ----
 *              2      4
 */

public class Task11 {
    public static void main(String[] args) {
        formulaA(9, 27);
        formulaB(2, 3);
    }

    public static void formulaA(double numX, double numY) {
        double numeratorLeft = Math.sqrt(numX) - 1; // левая часть числителя
        double numeratorRight = Math.cbrt(numY); // правая часть числителя
        double numeratorResult = numeratorLeft - numeratorRight; // результат полученный в числителе

        double denominatorLeft = 1 + Math.pow(numX, 2) / 2; // левая часть знаменателя
        double denominatorRight = Math.pow(numY, 2) / 4; // правая часть знаменателя
        double denominatorResult = denominatorLeft + denominatorRight; // результат полученный в знаменателе

        double result = numeratorResult / denominatorResult; // общий результат
        System.out.println("Результат по формуле а = " + result);
    }

    public static void formulaB(double numX, double numZ) {
        double example = numX * (Math.atan(numZ)) + Math.pow(Math.E, -(numX + 3)); // результат формулы (b)
        System.out.println("Результат по формуле b = " + example);
    }
}

package politeh.firstcourse;

/**
 * 11. ���� �, �, z. ��������� a, b ����
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
        double numeratorLeft = Math.sqrt(numX) - 1; // ����� ����� ���������
        double numeratorRight = Math.cbrt(numY); // ������ ����� ���������
        double numeratorResult = numeratorLeft - numeratorRight; // ��������� ���������� � ���������

        double denominatorLeft = 1 + Math.pow(numX, 2) / 2; // ����� ����� �����������
        double denominatorRight = Math.pow(numY, 2) / 4; // ������ ����� �����������
        double denominatorResult = denominatorLeft + denominatorRight; // ��������� ���������� � �����������

        double result = numeratorResult / denominatorResult; // ����� ���������
        System.out.println("��������� �� ������� � = " + result);
    }

    public static void formulaB(double numX, double numZ) {
        double example = numX * (Math.atan(numZ)) + Math.pow(Math.E, -(numX + 3)); // ��������� ������� (b)
        System.out.println("��������� �� ������� b = " + example);
    }
}

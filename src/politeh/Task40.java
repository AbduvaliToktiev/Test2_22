package politeh;

/**
 * ���� ��� �������������� �����. �������� ������
 * ����� �����, ���� ��� ������ ��� ����� �������, � �������� ����� ��� ��������� � ��������� ������.
 */

public class Task40 {
    public static void main(String[] args) {
        equal(1, 5);
    }

    public static void equal(int numX, int numY) {
        if (numX < numY || numX == numY) {
            numX = 0;
        }
        System.out.println("������ �����: " + numX + "\n" +
                "������ �����: " + numY);
    }
}

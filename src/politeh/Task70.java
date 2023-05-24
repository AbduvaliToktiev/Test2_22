package politeh;

/**
 * 77. ���� ����������� ����� �. ���������:
 * �) 2^n;
 * �) n!;
 */

public class Task70 {
    public static void main(String[] args) {
        int number = 4, result;
        result = factorial(number);
        System.out.println("��������� �����: " + number + " = " + result);

        pow(2);
    }

    public static void pow(int numN) { // ������� (a)
        int result = 1;
        for (int i = 0; i < numN; i++) {
            result = result * numN;
        }
        System.out.println(result);
    }

    public static int factorial(int num) { // ������� (b)
        if (num != 0)
            return num * factorial(num - 1);
        else
            return 1;
    }
}

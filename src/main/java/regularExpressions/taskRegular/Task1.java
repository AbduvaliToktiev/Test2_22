package regularExpressions.taskRegular;

import java.util.regex.Pattern;

/**
 * Написать программу, проверяющую, является ли введённая
 * строка адресом почтового ящика.
 * В названии почтового ящика разрешить использование только
 * букв, цифр и нижных подчёркиваний, при этом оно должно
 * начинать с буквы.
 * Возможные домены верхнего уровня: .org .com
 */

public class Task1 {
    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(org|com)";
        String input = "toktievabdyvali@gmail.com";
        System.out.println(Pattern.matches(regex, input));
    }
}

package regularExpressions.taskRegular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать программу, выполняющую поиск в строке
 * шестнацетиричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */

public class Task2 {
    public static void main(String[] args) {
        String regex = "0[Xx][0-9a-fA-F]+";
        String input = "asdasd 0Xff adas 0x12 adsasd 0XAB asdad 1x24F ASA";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

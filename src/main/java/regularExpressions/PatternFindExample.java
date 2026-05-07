package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "asdad +996 (706) 17-30-81 adadsa asdda +996 (777) 17-30-81 adsadas +996 (555) 17-30-81" +
                "asdad +996 (700) 17-30-81 asdas";
        String regex = "(?:\\+996)? ?\\((?<code>\\d{3})\\) ?\\d{2}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group("code"));
        }
    }
}

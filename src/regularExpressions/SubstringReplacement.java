package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringReplacement {
    public static void main(String[] args) {
        String phoneNumber = "asdad +996 (706) 17-30-81 adadsa asdda +996 (777) 17-30-81 adsadas +996 (555) 17-30-81" +
                "asdad +996 (700) 17-30-81 asdas";
        String regex = "(?:\\+996)? ?\\((?<code>\\d{3})\\) ?(\\d{2})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
           String gr1 = matcher.group(2);
           String gr2 = matcher.group(3);
           String gr3 = matcher.group(4);
           matcher.appendReplacement(stringBuilder, "$2 - $3 - $4");
        }
        matcher.appendTail(stringBuilder);

        System.out.println(stringBuilder);
        System.out.println(phoneNumber.replaceAll(regex, "$2 - $3 - $4 | "));
    }
}

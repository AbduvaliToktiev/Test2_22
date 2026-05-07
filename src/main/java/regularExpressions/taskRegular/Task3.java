package regularExpressions.taskRegular;

/**
 * Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например<p id
 * = "p1">,
 * и замену их на простые теги абзацев <p>.
 */

public class Task3 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p> adsasda </p> <b> asdas </b> dasdasdasda <p id = \"p1\" asdasd</p>" +
                "asdsad <p>asass dasda <p id = \"p2\"> 2133 assadsa </p> asdsad";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }
}

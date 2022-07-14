import static java.lang.System.out;

// Код для дублирования строк
public class Test {
    public static void main(String[] args) {
        String s = "adsADASDASD";
        String[] rows = s.split("\n");
        String[] words = s.split(" ");
        for (String item : rows) {
            String changed = null;
            for(String item2:words) {
                changed = item.replaceAll(item2, item2+" "+item2);
            }
            out.println(changed);
        }
    }
}


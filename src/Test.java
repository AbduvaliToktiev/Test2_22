import java.util.*;
import java.text.SimpleDateFormat;

// Код для дублирования строк
public class Test {
    public static void main(String[] args) throws Exception {
        String s = "adsADASDASD";
        String[] rows = s.split("\n");
        String[] words = s.split(" ");
        for (String item : rows) {
            String changed = null;
            for (String item2 : words) {
                changed = item.replaceAll(item2, item2 + " " + item2);
            }
            //    out.println(changed);
            //  System.out.println(readDate(new Scanner(System.in), "dd/MM/YYYY"));
            readDate();
        }
    }


    //   public static Date readDate(Scanner sc, String format) throws ParseException {
    //       return new SimpleDateFormat(format).parse(sc.nextLine());
    //   }
// Для даты в базу данных
    public static void readDate() throws Exception {
        String dateFormat = "dd/MM/yyyy";
        Scanner scanner = new Scanner(System.in);
        setDate(new SimpleDateFormat(dateFormat).parse(scanner.nextLine()));
    }

    public static void setDate(Date date) {
        System.out.println(date);
    }
}


class Exercise2 {
    public static void main(String[] args) {
        // Creae a list and add some colors to the list
        List<String> list_Strings = new ArrayList<String>();
        list_Strings.add("Red");
        list_Strings.add("Green");
        list_Strings.add("Orange");
        list_Strings.add("White");
        list_Strings.add("Black");
        // Print the list
        for (String element : list_Strings) {
            System.out.println(element);
        }
    }
}




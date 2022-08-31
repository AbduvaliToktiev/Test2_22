import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

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

class Main {

    // unsorted
    static Map<String, Integer> lhmap = new HashMap<>();

    public static void sort()
    {
        HashMap<String, Integer> x
                = lhmap.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getKey().compareTo(
                        i2.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (z1, z2) -> z1, LinkedHashMap::new));

        // Show Sorted HashMap
        for (Map.Entry<String, Integer> start :
                x.entrySet()) {
            System.out.println("Your Key " + start.getKey()
                    + ", Your Value = "
                    + start.getValue());
        }
    }

    public static void main(String args[])
    {
        // insert value
        lhmap.put("a", 1);
        lhmap.put("aa", 3);
        lhmap.put("ab", 5);
        lhmap.put("ba", 7);
        lhmap.put("bb", 8);
        lhmap.put("aac", 23);
        lhmap.put("bac", 8);
        sort();
    }

}




import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

// Код для дублирования строк
public class Test {
    public static void main(String[] args) {
        System.out.println(Math.atan(1));
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

    public static void sort() {
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

    public static void main(String args[]) {
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

class DateForma {
    public static void main(String[] args) throws ParseException {
        DateFormat outputFormat = new SimpleDateFormat("MM/yyyy", Locale.US);
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);

        String inputText = "2012-11-17T00:00:00.000-05:00";
        Date date = inputFormat.parse(inputText);
        String outputText = outputFormat.format(date);
        System.out.println(outputText);
    }
}




package Map;

import java.util.*;

public class MainLinkedHashMap {
    public static void main(String args[]) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("three", 3);
        linkedHashMap.put("four", 4);
        linkedHashMap.put("five", 5);

       // for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
       //     System.out.println(entry.getKey() + " - " + entry.getValue());
       // }

        Iterator<Map.Entry<String, Integer>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entryIterator = iterator.next();
            System.out.println(entryIterator);
        }
    }
}


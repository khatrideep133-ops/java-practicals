import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java is easy and java is powerful and java is popular";

        Map<String, Integer> map = new HashMap<>();

        for (String word : text.toLowerCase().split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> e : list)
            System.out.println(e.getKey() + " -> " + e.getValue());
    }
}

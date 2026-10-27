import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Riya", 90);
        scores.put("Amit", 95);
        scores.put("John", 90);
        scores.put("Neha", 98);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(scores.entrySet());

        list.sort((a, b) -> {
            int scoreCompare = b.getValue().compareTo(a.getValue());
            if (scoreCompare != 0) return scoreCompare;
            return a.getKey().compareTo(b.getKey());
        });

        for (int i = 0; i < Math.min(3, list.size()); i++)
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
    }
}

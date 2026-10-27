import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        String[] logins = {"Riya", "Amit", "Riya", "John", "Amit", "Neha"};

        HashSet<String> unique = new HashSet<>(Arrays.asList(logins));
        LinkedHashSet<String> order = new LinkedHashSet<>(Arrays.asList(logins));

        System.out.println("Unique count: " + unique.size());

        int count = 0;
        for (String name : order) {
            if (count == 3) break;
            System.out.println(name);
            count++;
        }
    }
}

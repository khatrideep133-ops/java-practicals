import java.util.*;

public class Practical12 {
    static class Account {
        String number, holder;
        double balance;
        Account(String number, String holder, double balance) {
            this.number = number; this.holder = holder; this.balance = balance;
        }
        public String toString() { return number + " | " + holder + " | " + balance; }
    }
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>(List.of(
            new Account("AC1003", "Meera", 1200),
            new Account("AC1001", "Riya", 8000),
            new Account("AC1002", "Aarav", 4200)
        ));
        accounts.sort(Comparator.comparingDouble(a -> a.balance));
        System.out.println("Sorted by balance:");
        accounts.forEach(System.out::println);

        Map<String, Account> byNumber = new HashMap<>();
        for (Account a : accounts) byNumber.put(a.number, a);
        System.out.println("Lookup AC1001: " + byNumber.get("AC1001"));
        Set<String> uniqueHolders = new TreeSet<>();
        for (Account a : accounts) uniqueHolders.add(a.holder);
        System.out.println("Unique holders: " + uniqueHolders);
    }
}

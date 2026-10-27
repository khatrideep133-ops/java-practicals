import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Practical14 {
    static class Account {
        final String number, holder;
        double balance;
        Account(String number, String holder, double balance) {
            this.number = number; this.holder = holder; this.balance = balance;
        }
        void deposit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            balance += amount;
        }
        void withdraw(double amount) {
            if (amount <= 0 || amount > balance) throw new IllegalArgumentException("Invalid amount or insufficient funds");
            balance -= amount;
        }
        public String toString() { return number + " | " + holder + " | " + balance; }
    }
    static class BankService {
        private final Map<String, Account> accounts = new LinkedHashMap<>();
        void add(Account account) {
            if (accounts.putIfAbsent(account.number, account) != null)
                throw new IllegalArgumentException("Duplicate account");
        }
        Account find(String number) { return accounts.get(number); }
        List<Account> all() { return new ArrayList<>(accounts.values()); }
        void saveReport(Path path) throws IOException {
            List<String> lines = new ArrayList<>();
            for (Account a : accounts.values()) lines.add(a.toString());
            Files.write(path, lines);
        }
    }
    public static void main(String[] args) throws IOException {
        BankService service = new BankService();
        service.add(new Account("AC1001", "Riya", 5000));
        service.add(new Account("AC1002", "Aarav", 2500));
        service.find("AC1001").deposit(1000);
        service.find("AC1002").withdraw(500);
        service.saveReport(Path.of("bank-report.txt"));
        service.all().forEach(System.out::println);
        System.out.println("Report saved to bank-report.txt");
    }
}

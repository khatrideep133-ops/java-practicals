import java.io.*;
import java.nio.file.*;
import java.util.logging.*;

public class Practical11 {
    static class AccountRecord implements Serializable {
        private static final long serialVersionUID = 1L;
        String accountNo;
        double balance;
        AccountRecord(String accountNo, double balance) { this.accountNo = accountNo; this.balance = balance; }
        public String toString() { return accountNo + " balance=" + balance; }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logger logger = Logger.getLogger("MiniBank");
        Path file = Path.of("account-record.dat");
        AccountRecord original = new AccountRecord("AC1001", 8750.50);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(original);
        }
        AccountRecord loaded;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            loaded = (AccountRecord) in.readObject();
        }
        logger.info("Loaded account record");
        Path report = Path.of("end-of-day.txt");
        Files.writeString(report, loaded + System.lineSeparator());
        System.out.println(Files.readString(report));
    }
}

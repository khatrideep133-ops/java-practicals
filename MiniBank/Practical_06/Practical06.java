interface Transferable {
    void transferTo(TransferableAccount target, double amount);
}
class TransferableAccount implements Transferable {
    private final String accountNo;
    private double balance;
    TransferableAccount(String accountNo, double balance) {
        this.accountNo = accountNo; this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Positive amount required");
        balance += amount;
    }
    public void transferTo(TransferableAccount target, double amount) {
        if (target == null || target == this) throw new IllegalArgumentException("Invalid target");
        if (amount <= 0 || balance < amount) throw new IllegalArgumentException("Invalid amount or insufficient funds");
        balance -= amount; target.deposit(amount);
    }
    public void display() { System.out.printf("%s: %.2f%n", accountNo, balance); }
}
public class Practical06 {
    public static void main(String[] args) {
        TransferableAccount a = new TransferableAccount("AC1001", 5000);
        TransferableAccount b = new TransferableAccount("AC1002", 1000);
        a.transferTo(b, 1250);
        a.display(); b.display();
    }
}

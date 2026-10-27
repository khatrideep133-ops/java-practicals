abstract class BankAccount {
    protected final String accountNo;
    protected double balance;
    BankAccount(String accountNo, double balance) {
        this.accountNo = accountNo; this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }
    public abstract boolean withdraw(double amount);
    public void display() { System.out.printf("%s balance: %.2f%n", accountNo, balance); }
}
class SavingsAccount extends BankAccount {
    SavingsAccount(String no, double balance) { super(no, balance); }
    @Override public boolean withdraw(double amount) {
        if (amount <= 0 || balance - amount < 500) return false;
        balance -= amount; return true;
    }
}
class CurrentAccount extends BankAccount {
    private final double overdraftLimit;
    CurrentAccount(String no, double balance, double limit) {
        super(no, balance); overdraftLimit = limit;
    }
    @Override public boolean withdraw(double amount) {
        if (amount <= 0 || balance - amount < -overdraftLimit) return false;
        balance -= amount; return true;
    }
}
public class Practical05 {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("AC1001", 2000);
        BankAccount current = new CurrentAccount("AC2001", 1000, 5000);
        System.out.println("Savings withdrawal: " + savings.withdraw(700));
        System.out.println("Current withdrawal: " + current.withdraw(3000));
        savings.display(); current.display();
    }
}

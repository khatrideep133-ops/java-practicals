class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) { super(message); }
}
class BankAccount {
    private double balance;
    BankAccount(double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        balance = openingBalance;
    }
    void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new InsufficientFundsException("Not enough balance");
        balance -= amount;
    }
    double getBalance() { return balance; }
}
public class Practical08 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        try {
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction rejected: " + e.getMessage());
        }
        System.out.println("Balance: " + account.getBalance());
    }
}

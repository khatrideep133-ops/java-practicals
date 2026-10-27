import static java.lang.System.out;

interface Transactable {
    void deposit(long amount);

    boolean withdraw(long amount);
}

interface InterestBearing {
    double interestRate();

    long getBalance();

    default double yearlyInterest() {
        return getBalance() * interestRate() / 100;
    }
}

@FunctionalInterface
interface WithdrawRule {
    boolean allow(Account account, long amount);
}

interface Premium {
}

class Account implements Transactable, InterestBearing, Premium {
    private String accountNumber;
    private long balance;

    Account(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(long amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double interestRate() {
        return 4.0;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class MiniBank {
    public static void main(String[] args) {
        Account account = new Account("AC0001", 5000);

        WithdrawRule rule1 = new WithdrawRule() {
            public boolean allow(Account account, long amount) {
                return amount > 0 && amount <= account.getBalance();
            }
        };

        WithdrawRule rule2 = (acc, amount) -> amount > 0 && amount <= acc.getBalance();

        out.println("Account: " + account.getAccountNumber());
        out.println("Balance: " + account.getBalance());
        out.println("Yearly interest: " + account.yearlyInterest());
        out.println("Anonymous rule: " + rule1.allow(account, 1000));
        out.println("Lambda rule: " + rule2.allow(account, 1000));
        account.deposit(1000);
        account.withdraw(500);

        out.println("Updated balance: " + account.getBalance());
        out.println("Premium account: " + (account instanceof Premium));
    }
}

abstract class Account {
    String accountNumber;
    String ownerName;
    long balance;

    Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    abstract double interestRate();

    abstract boolean canWithdraw(long amount);
}

class SavingsAccount extends Account {
    long minBalance;

    SavingsAccount(String number, String owner, long balance, long minBalance) {
        super(number, owner, balance);
        this.minBalance = minBalance;
    }

    double interestRate() {
        return 4.0;
    }

    boolean canWithdraw(long amount) {
        return amount > 0 && balance - amount >= minBalance;
    }
}

class CurrentAccount extends Account {
    long overdraftLimit;

    CurrentAccount(String number, String owner, long balance, long overdraftLimit) {
        super(number, owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    double interestRate() {
        return 0.0;
    }

    boolean canWithdraw(long amount) {
        return amount > 0 && balance - amount >= -overdraftLimit;
    }
}

class FixedDepositAccount extends Account {

    FixedDepositAccount(String number, String owner, long balance) {
        super(number, owner, balance);
    }

    double interestRate() {
        return 7.0;
    }

    boolean canWithdraw(long amount) {
        return false;
    }
}

public class MiniBank {
    public static void main(String[] args) {
        Account[] accounts = {
                new SavingsAccount("AC0001", "Riya", 10000, 2000),
                new CurrentAccount("AC0002", "Amit", 5000, 3000), new FixedDepositAccount("AC0003", "Jay", 20000)
        };
        for (Account account : accounts) {
            System.out.println(account.accountNumber + " interest rate: "
                    + account.interestRate() + "%");

            if (account instanceof SavingsAccount savings) {
                System.out.println("Savings withdrawal allowed: "
                        + savings.canWithdraw(3000));
            }
        }
    }
}
class SharedAccount {
    private int balance = 1000;
    public synchronized void deposit(int amount) {
        balance += amount;
    }
    public synchronized boolean withdraw(int amount) {
        if (amount > balance) return false;
        balance -= amount; return true;
    }
    public synchronized int getBalance() { return balance; }
}
public class Practical09 {
    public static void main(String[] args) throws InterruptedException {
        SharedAccount account = new SharedAccount();
        Thread depositor = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.deposit(10);
        }, "Depositor");
        Thread withdrawer = new Thread(() -> {
            for (int i = 0; i < 500; i++) account.withdraw(10);
        }, "Withdrawer");
        depositor.start(); withdrawer.start();
        depositor.join(); withdrawer.join();
        System.out.println("Final balance: " + account.getBalance());
    }
}

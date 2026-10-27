class Customer {
	private String name;
	private String email;
	private String mobile;
	private final String customerId;
	private static long customerCounter = 100;

	private static String generateCustomerId() {
		customerCounter++;
		return "CUST" + customerCounter;
	}

	Customer(String name, String email, String mobile) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.customerId = generateCustomerId();
	}

	String getName() {
		return name;
	}

	String getEmail() {
		return email;
	}

	String getMobile() {
		return mobile;
	}

	String getCustomerId() {
		return customerId;
	}
}

public class Account {
	private final String accountNumber;
	private String ownerName;
	private long balance;
	private boolean active;
	private static int accountCounter = 0;

	Account(String ownerName, long balance) {
		this.ownerName = ownerName;
		this.balance = balance;
		this.active = true;
		accountCounter++;
		accountNumber = String.format("AC%04d", accountCounter);
	}

	Account(String ownerName) {
		this(ownerName, 0);
	}

	void deposit(long amount) {
		if (amount > 0 && active) {
			balance += amount;
		}
	}

	boolean withdraw(long amount) {
		if (amount > 0 && amount <= balance && active) {
			balance -= amount;
			return true;
		}
		return false;
	}

	String getAccountNumber() {
		return accountNumber;
	}

	String getOwnerName() {
		return ownerName;
	}

	long getBalance() {
		return balance;
	}

	boolean isActive() {
		return active;
	}

	public static void main(String[] args) {
		Customer c1 = new Customer("Rahul", "rahul@gmail.com", "9876543210");

		Account[] accounts = {
				new Account(c1.getName(), 5000),
				new Account("Amit", 3000), new Account("Neha")
		};
		accounts[0].deposit(2000);
		accounts[0].withdraw(1000);
		accounts[1].withdraw(4000);
		accounts[1].deposit(500);
		accounts[2].deposit(1500);
		System.out.println("Customer ID: " + c1.getCustomerId());
		for (Account account : accounts) {

			System.out.println(
					account.getAccountNumber() + " " + account.getOwnerName() + " Balance: " + account.getBalance());
		}
	}
}

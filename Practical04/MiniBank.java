import java.util.regex.Pattern;

class Validator {
	private static final Pattern MOBILE = Pattern.compile("[6-9][0-9]{9}");
	private static final Pattern EMAIL = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
	private static final Pattern PAN = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]");
	private static final Pattern IFSC = Pattern.compile("[A-Z]{4}0[A-Z0-9]{6}");

	public static boolean isValidMobile(String s) {
		return MOBILE.matcher(s).matches();
	}

	public static boolean isValidEmail(String s) {
		return EMAIL.matcher(s).matches();
	}

	public static boolean isValidPan(String s) {
		return PAN.matcher(s).matches();
	}

	public static boolean isValidIfsc(String s) {
		return IFSC.matcher(s).matches();
	}
}

enum TransactionType {
	DEPOSIT, WITHDRAW, TRANSFER
}

record Command(TransactionType type, String accountNumber, long amount) {
}

class CommandParser {
	public static Command parse(String line) {
		String[] parts = line.trim().split("\\s+");

		if (parts.length != 3) {
			throw new IllegalArgumentException("Invalid command");
		}

		TransactionType type = TransactionType.valueOf(parts[0]);
		String accountNumber = parts[1];
		long amount = Long.parseLong(parts[2]);

		return new Command(type, accountNumber, amount);
	}
}

class Account {
	String accountNumber;
	String ownerName;
	long balance;

	Account(String accountNumber, String ownerName, long balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
}

class StatementFormatter {
	public static String buildStatement(Account account) {
		StringBuilder statement = new StringBuilder();
		statement.append("Account Number: ").append(account.accountNumber);
		statement.append("\nOwner: ").append(account.ownerName);
		statement.append("\nBalance: ").append(account.balance);
		return statement.toString();
	}
}

public class MiniBank {
	public static void main(String[] args) {
		System.out.println(Validator.isValidMobile("9876543210"));
		System.out.println(Validator.isValidMobile("12345"));
		System.out.println(Validator.isValidEmail("riya@gmail.com"));
		System.out.println(Validator.isValidEmail("riya@gmail"));
		System.out.println(Validator.isValidPan("ABCDE1234F"));
		System.out.println(Validator.isValidIfsc("SBIN0001234"));
		Command command = CommandParser.parse("DEPOSIT AC0001 500");
		System.out.println("type=" + command.type()
				+ ", accountNumber=" + command.accountNumber()
				+ ", amount=" + command.amount());

		Account account = new Account("AC0001", "Riya", 4000);
		System.out.println(StatementFormatter.buildStatement(account));
	}
}

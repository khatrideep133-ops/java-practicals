import java.util.Scanner;

enum AccountType { SAVINGS, CURRENT }

public class Practical01 {
    static final String BANK_NAME = "MiniBank";
    static final String IFSC = "MBIN0001234";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to " + BANK_NAME + " | IFSC: " + IFSC);
        System.out.println("1. Savings Account\n2. Current Account");
        System.out.print("Choose account type: ");
        int choice = sc.nextInt();

        AccountType type;
        switch (choice) {
            case 1 -> type = AccountType.SAVINGS;
            case 2 -> type = AccountType.CURRENT;
            default -> {
                System.out.println("Invalid choice.");
                sc.close();
                return;
            }
        }
        System.out.println("Selected account type: " + type);
        sc.close();
    }
}

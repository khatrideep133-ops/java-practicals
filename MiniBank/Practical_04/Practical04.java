import java.util.Scanner;

public class Practical04 {
    static boolean validAccountNo(String value) { return value != null && value.matches("AC\\d{4,10}"); }
    static boolean validMobile(String value) { return value != null && value.matches("[6-9]\\d{9}"); }
    static boolean validAmount(String value) { return value != null && value.matches("\\d+(\\.\\d{1,2})?"); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Account number (AC followed by 4-10 digits): ");
        String account = sc.nextLine().trim();
        System.out.print("Indian mobile number: ");
        String mobile = sc.nextLine().trim();
        System.out.print("Amount: ");
        String amount = sc.nextLine().trim();
        System.out.println("Account valid: " + validAccountNo(account));
        System.out.println("Mobile valid: " + validMobile(mobile));
        System.out.println("Amount valid: " + validAmount(amount));
        sc.close();
    }
}

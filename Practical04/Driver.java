class PasswordChecker {
    public static String strength(String pw) {
        int count = 0;
        if (pw.length() >= 8)
            count++;
        if (pw.matches(".*[A-Z].*"))
            count++;
        if (pw.matches(".*[0-9].*"))
            count++;
        if (pw.matches(".*[^a-zA-Z0-9].*"))
            count++;

        if (count <= 1)
            return "Weak";
        if (count <= 3)
            return "Medium";
        return "Strong";
    }

    public static void check(String pw) {
        System.out.println("Password: " + pw);
        System.out.println("Length >= 8: " + (pw.length() >= 8));
        System.out.println("Uppercase: " + pw.matches(".*[A-Z].*"));
        System.out.println("Digit: " + pw.matches(".*[0-9].*"));
        System.out.println("Special character: " + pw.matches(".*[^a-zA-Z0-9].*"));
        System.out.println("Strength: " + strength(pw));
        System.out.println();
    }
}

public class Driver {
    public static void main(String[] args) {
        PasswordChecker.check("abc");
        PasswordChecker.check("Abcd1234!");
    }
}

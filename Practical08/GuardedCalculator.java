import java.util.*;

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) { super(message); }
}

public class GuardedCalculator {
    static double calculate(double a, double b, char op) throws DivideByZeroException {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new DivideByZeroException("Cannot divide by zero");
                return a / b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number: ");
                double a = Double.parseDouble(sc.next());

                System.out.print("Enter second number: ");
                double b = Double.parseDouble(sc.next());

                System.out.print("Enter operator (+ - * /): ");
                char op = sc.next().charAt(0);

                System.out.println("Result: " + calculate(a, b, op));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Attempt completed.");
            }
        }
    }
}

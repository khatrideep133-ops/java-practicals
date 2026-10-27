
import java.util.*;

@FunctionalInterface
interface DiscountRule {
    double apply(double price);
}

public class DiscountEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] prices = { 1000, 2000, 3000 };

        System.out.println("1. 10% discount");
        System.out.println("2. 20% discount");
        System.out.println("3. No discount");
        System.out.print("Choose rule: ");
        int choice = sc.nextInt();
        DiscountRule rule = switch (choice) {
            case 1 -> price -> price * 0.90;
            case 2 -> price -> price * 0.80;
            default -> price -> price;
        };

        double total = 0;

        for (double price : prices) {
            double finalPrice = rule.apply(price);
            System.out.printf("%.2f -> %.2f%n", price, finalPrice);
            total += finalPrice;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

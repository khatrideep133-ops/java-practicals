import java.util.Scanner;

public class TollBooth {
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0, bike = 0, car = 0, truck = 0;

        while (true) {
            System.out.print("Vehicle number (done to stop): ");
            String number = sc.next();
            if (number.equalsIgnoreCase("done")) break;

            System.out.print("Type (bike/car/truck): ");
            String type = sc.next().toLowerCase();
            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            total += toll;
            if (type.equals("bike")) bike++;
            else if (type.equals("car")) car++;
            else if (type.equals("truck")) truck++;
        }

        String most = "bike";
        int highest = bike;
        if (car > highest) { highest = car; most = "car"; }
        if (truck > highest) { most = "truck"; }

        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + most);
    }
}

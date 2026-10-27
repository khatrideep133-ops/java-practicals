public class ParkingLot {
    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public void park(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked");
            } else System.out.println("Full");
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked");
            } else System.out.println("Full");
        }
    }

    public void leave(String type) {
        if (type.equalsIgnoreCase("two") && twoWheelers > 0) twoWheelers--;
        if (type.equalsIgnoreCase("four") && fourWheelers > 0) fourWheelers--;
    }

    public static void main(String[] args) {
        ParkingLot p = new ParkingLot(2, 2);
        p.park("two");
        p.park("two");
        p.park("two");
        p.park("four");
        p.park("four");
        p.park("four");
        p.leave("two");

        System.out.println("Two-wheelers: " + p.twoWheelers);
        System.out.println("Four-wheelers: " + p.fourWheelers);
        System.out.println("Revenue: " + revenue);
    }
}

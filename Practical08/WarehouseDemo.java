class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        super("Out of stock by " + shortfall);
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) { super(message); }
}

class Warehouse {
    int stock = 10;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) throw new InvalidQuantityException("Quantity must be positive");

        if (qty > stock)
            throw new OutOfStockException(qty - stock);

        stock -= qty;
        System.out.println("Issued " + qty + " " + item);
    }
}

public class WarehouseDemo {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        int[][] requests = {{3}, {20}, {0}, {4}};

        for (int[] r : requests) {
            try {
                w.issue("Pen", r[0]);
            } catch (Exception e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }

        System.out.println("Remaining stock: " + w.stock);
    }
}

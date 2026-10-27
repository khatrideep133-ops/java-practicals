class Seats {
    int seatsLeft = 5;

    synchronized boolean book() {
        if (seatsLeft > 0) {
            seatsLeft--;
            return true;
        }
        return false;
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        Seats seats = new Seats();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                if (seats.book())
                    System.out.println(Thread.currentThread().getName() + " booked");
                else
                    System.out.println(Thread.currentThread().getName() + " failed");
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Seats left: " + seats.seatsLeft);
    }
}

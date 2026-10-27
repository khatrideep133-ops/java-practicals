class Counter {
    int value = 0;

    synchronized void increment() {
        value++;
    }
}

public class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    c.increment();
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Final counter: " + c.value);
    }
}

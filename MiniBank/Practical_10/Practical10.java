import java.util.concurrent.*;

public class Practical10 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            pool.submit(() -> System.out.println("Processing transaction " + taskId
                    + " on " + Thread.currentThread().getName()));
        }
        pool.shutdown();
        if (!pool.awaitTermination(5, TimeUnit.SECONDS)) pool.shutdownNow();

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        Thread producer = new Thread(() -> {
            try {
                queue.put("Deposit"); queue.put("Withdrawal"); queue.put("STOP");
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try {
                String item;
                while (!(item = queue.take()).equals("STOP"))
                    System.out.println("Consumed: " + item);
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start();
        producer.join(); consumer.join();
    }
}

public class ParallelSum {
    static long total = 0;

    static class Worker extends Thread {
        int[] array;
        int start, end;

        Worker(int[] array, int start, int end) {
            this.array = array; this.start = start; this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                synchronized (ParallelSum.class) {
                    total += array[i];
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        Thread t1 = new Worker(numbers, 0, 50);
        Thread t2 = new Worker(numbers, 50, 100);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Total: " + total);
    }
}

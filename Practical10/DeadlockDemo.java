public class DeadlockDemo {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("T1 has lock1");
                synchronized (lock2) {
                    System.out.println("T1 has lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("T2 has lock2");
                synchronized (lock1) {
                    System.out.println("T2 has lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

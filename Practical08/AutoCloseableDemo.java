class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Resource opened");
    }

    public void use() {
        System.out.println("Resource used");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (MyResource r = new MyResource()) {
            r.use();
            throw new RuntimeException("Some error");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}

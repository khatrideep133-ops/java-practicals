class Box<T> {
    private T value;

    void set(T value) { this.value = value; }
    T get() { return value; }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

public class GenericContainers {
    static <T> T first(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.set("Hello");

        Box<Integer> box2 = new Box<>();
        box2.set(100);

        Pair<String, Integer> p = new Pair<>("Age", 20);

        String[] names = {"Riya", "Amit"};
        System.out.println(box1.get());
        System.out.println(box2.get());
        System.out.println(p.first + " = " + p.second);
        System.out.println("First: " + first(names));
    }
}

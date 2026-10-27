class GenericStack<T> {
    private Object[] data;
    private int top = -1;

    GenericStack(int size) {
        data = new Object[size];
    }

    void push(T value) {
        if (top == data.length - 1) {
            System.out.println("Stack full");
            return;
        }
        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    T pop() {
        if (top == -1) {
            System.out.println("Stack empty");
            return null;
        }
        return (T) data[top--];
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        GenericStack<Integer> s1 = new GenericStack<>(5);
        s1.push(10);
        s1.push(20);
        System.out.println(s1.pop());

        GenericStack<String> s2 = new GenericStack<>(5);
        s2.push("Java");
        System.out.println(s2.pop());
    }
}

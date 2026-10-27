public class BoundedStats {
    static <N extends Number> double average(N[] values) {
        double total = 0;

        for (N value : values)
            total += value.doubleValue();

        return total / values.length;
    }

    public static void main(String[] args) {
        Integer[] a = {10, 20, 30};
        Double[] b = {1.5, 2.5, 3.5};
        Long[] c = {100L, 200L, 300L};

        System.out.println(average(a));
        System.out.println(average(b));
        System.out.println(average(c));
    }
}

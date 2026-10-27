public class Practical02 {
    static class Customer {
        private final String customerId;
        private String name;
        private String email;

        public Customer(String customerId, String name, String email) {
            this.customerId = customerId;
            setName(name);
            setEmail(email);
        }
        public String getCustomerId() { return customerId; }
        public String getName() { return name; }
        public void setName(String name) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
            this.name = name.trim();
        }
        public String getEmail() { return email; }
        public void setEmail(String email) {
            if (email == null || !email.matches("^[\\w.+-]+@[\\w.-]+\\.[A-Za-z]{2,}$"))
                throw new IllegalArgumentException("Invalid email");
            this.email = email;
        }
        @Override public String toString() {
            return customerId + " | " + name + " | " + email;
        }
    }
    public static void main(String[] args) {
        Customer c = new Customer("CU1001", "Riya Shah", "riya@example.com");
        System.out.println(c);
    }
}

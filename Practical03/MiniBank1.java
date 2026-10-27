import java.util.Objects;

class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private static int counter = 1;

    public Account(String ownerName, long balance) {
        this.accountNumber = String.format("AC%04d", counter++);
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public String toString() {
        return accountNumber + " | " + ownerName + " | " + balance;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Account)) {
            return false;
        }
        Account a = (Account) o;
        return accountNumber.equals(a.accountNumber);
    }

    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

class Customer implements Cloneable {
    private String name;
    private String email;
    private String mobile;
    private Address address;

    public Customer(String name, String email, String mobile, Address address) {
        this.name = name;

        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Customer clone() {
        try {
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Address {
        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }
}

public class MiniBank1 {
    public static void main(String[] args) {
        Account a1 = new Account("Riya", 4000);
        Account a2 = a1;

        System.out.println(a1);
        System.out.println(a1.equals(a2));
        System.out.println(a1 instanceof Account);

        Customer.Address address =

                new Customer.Address("Main Road", "Surat", "395001");

        Customer c1 = new Customer("Riya", "riya@example.com", "9876543210", address);
        Customer c2 = c1.clone();
        System.out.println(c2.getAddress().getCity());
    }
}

public class Practical03 {
    static class Address {
        String city;
        String country;
        Address(String city, String country) { this.city = city; this.country = country; }
        @Override public String toString() { return city + ", " + country; }
    }
    static class Account implements Cloneable {
        private final String accountNo;
        private String holder;
        private double balance;
        private Address address;
        Account(String accountNo, String holder, double balance, Address address) {
            this.accountNo = accountNo; this.holder = holder;
            this.balance = balance; this.address = address;
        }
        @Override public String toString() {
            return accountNo + " | " + holder + " | balance=" + balance + " | " + address;
        }
        @Override public boolean equals(Object o) {
            return o instanceof Account a && accountNo.equals(a.accountNo);
        }
        @Override public int hashCode() { return accountNo.hashCode(); }
        @Override public Account clone() throws CloneNotSupportedException {
            Account copy = (Account) super.clone();
            copy.address = new Address(address.city, address.country);
            return copy;
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Account a = new Account("AC1001", "Riya", 5000, new Address("Ahmedabad", "India"));
        Account b = a.clone();
        System.out.println(a);
        System.out.println("Equal by account number: " + a.equals(b));
        System.out.println("Same object: " + (a == b));
    }
}

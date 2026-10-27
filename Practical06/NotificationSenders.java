@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {
}

class EmailNotifier implements Notifier, Urgent {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsNotifier implements Notifier {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

public class NotificationSenders {
    public static void main(String[] args) {
        Notifier[] senders = {
                new EmailNotifier(),
                new SmsNotifier()
        };

        String message = "Important notification";

        for (Notifier n : senders) {
            n.send(message);
            if (n instanceof Urgent) {
                n.send(message);
            }
        }
    }
}

interface Switchable {
    void on();

    void off();

    default void toggle() {
        off();
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }


    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

@FunctionalInterface
interface SwitchRule {
    boolean canSwitchOn(String device, int hour);
}

public class RemoteControl {
    public static void main(String[] args) {
        Switchable[] devices = { new Fan(), new Light() };
        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchRule rule1 = new SwitchRule() {
            public boolean canSwitchOn(String device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        SwitchRule rule2 = (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println(rule1.canSwitchOn("Fan", 10));
        System.out.println(rule2.canSwitchOn("Light", 23));
    }
}

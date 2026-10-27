import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Required {}

class CustomerRecord {
    @Required private String name = "Aarav";
    @Required private String email = "aarav@example.com";
    private String nickname = "";
}
public class Practical07 {
    public static void main(String[] args) throws IllegalAccessException {
        CustomerRecord record = new CustomerRecord();
        for (Field field : record.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Required.class)) {
                field.setAccessible(true);
                Object value = field.get(record);
                if (value == null || value.toString().isBlank())
                    System.out.println(field.getName() + " is required");
                else
                    System.out.println(field.getName() + " = " + value);
            }
        }
    }
}

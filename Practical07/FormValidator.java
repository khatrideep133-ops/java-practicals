import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    @MaxLength(10)
    String name;

    @NotBlank
    String email;

    SignupForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class FormValidator {
    static List<String> validate(Object obj) throws Exception {
        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotBlank.class)) {
                if (value == null || value.toString().trim().isEmpty())
                    errors.add(field.getName() + " must not be blank");
            }

            if (field.isAnnotationPresent(MaxLength.class) && value != null) {
                int max = field.getAnnotation(MaxLength.class).value();
                if (value.toString().length() > max)
                    errors.add(field.getName() + " is too long");
            }
        }

        return errors;
    }

    public static void main(String[] args) throws Exception {
        SignupForm form = new SignupForm("", "abc@gmail.com");
        for (String e : validate(form)) System.out.println(e);
    }
}

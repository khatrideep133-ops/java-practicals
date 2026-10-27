import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    public String toString() {
        return name + " " + age;
    }
}

public class ColumnMapper {
    public static void main(String[] args) throws Exception {
        String[] headers = {"name", "age"};
        String[] data = {"Riya", "20"};

        Student s = new Student();

        for (Field field : Student.class.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Column.class)) continue;

            String wanted = field.getAnnotation(Column.class).name();

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(wanted)) {
                    field.setAccessible(true);
                    if (field.getType() == String.class)
                        field.set(s, data[i]);
                    else if (field.getType() == int.class)
                        field.setInt(s, Integer.parseInt(data[i]));
                }
            }
        }

        System.out.println(s);
    }
}

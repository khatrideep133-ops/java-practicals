import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {}

class Entity {
    @Id private final String id;
    Entity(String id) { this.id = id; }
}
class Repository<T> {
    private final Map<String, T> records = new LinkedHashMap<>();
    private String getId(T item) {
        try {
            Class<?> type = item.getClass();
            while (type != null) {
                for (Field field : type.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Id.class)) {
                        field.setAccessible(true);
                        return String.valueOf(field.get(item));
                    }
                }
                type = type.getSuperclass();
            }
            throw new IllegalArgumentException("No @Id field found");
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }
    public void save(T item) { records.put(getId(item), item); }
    public Optional<T> findById(String id) { return Optional.ofNullable(records.get(id)); }
    public List<T> findAll() { return new ArrayList<>(records.values()); }
}
public class Practical13 {
    public static void main(String[] args) {
        Repository<Entity> repository = new Repository<>();
        repository.save(new Entity("AC1001"));
        System.out.println("Found AC1001: " + repository.findById("AC1001").isPresent());
        System.out.println("Total records: " + repository.findAll().size());
    }
}

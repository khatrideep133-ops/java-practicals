import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {
    public static void main(String[] args) {
        String template = "Dear {name}, order {id} ships {date}.";
        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder result = new StringBuilder();
        int last = 0;

        while (matcher.find()) {
            result.append(template, last, matcher.start());

            String key = matcher.group(1);
            String value = "[?]";

            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(key)) {
                    value = values[i];
                    break;
                }
            }

            result.append(value);
            last = matcher.end();
        }

        result.append(template.substring(last));
        System.out.println(result);
    }
}

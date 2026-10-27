import java.io.*;
import java.nio.file.*;

public class LogAnalyzer {
    public static void main(String[] args) throws Exception {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);

        Files.writeString(folder.resolve("one.txt"),
                "hello\njava\nhello again\n");
        Files.writeString(folder.resolve("two.txt"),
                "test\nhello world\n");

        String keyword = "hello";

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
            for (Path file : stream) {
                long lines = 0, matches = 0;

                try (BufferedReader br = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines++;
                        if (line.toLowerCase().contains(keyword)) matches++;
                    }
                }

                System.out.println(file.getFileName()
                        + " size=" + Files.size(file)
                        + " lines=" + lines
                        + " matches=" + matches);
            }
        }
    }
}

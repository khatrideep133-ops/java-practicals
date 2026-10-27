import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NioTree {
    public static void main(String[] args) throws Exception {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);

        Path report = Paths.get("file_report.txt");

        try (var writer = Files.newBufferedWriter(report)) {
            Files.walkFileTree(folder, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws java.io.IOException {
                    String line = file.getFileName() + " | " + attrs.size()
                            + " | " + attrs.lastModifiedTime();
                    System.out.println(line);
                    writer.write(line);
                    writer.newLine();
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}

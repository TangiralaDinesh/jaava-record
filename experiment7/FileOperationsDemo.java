import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationsDemo {
    public static void main(String[] args) {
        Path input = Paths.get("student.txt");
        Path report = Paths.get("result.txt");
        int passed = 0;
        int failed = 0;
        int total = 0;
        int count = 0;

        try {
            try (BufferedWriter writer = Files.newBufferedWriter(input)) {
                writer.write("101,Aravind,78");
                writer.newLine();
                writer.write("102,Divya,91");
                writer.newLine();
                writer.write("103,Karthik,45");
                writer.newLine();
            }

            System.out.println("ROLL   NAME       MARKS");
            try (BufferedReader reader = Files.newBufferedReader(input);
                 BufferedWriter writer = Files.newBufferedWriter(report)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length != 3) {
                        continue;
                    }
                    int marks;
                    try {
                        marks = Integer.parseInt(fields[2]);
                    } catch (NumberFormatException exception) {
                        System.out.println("Skipped invalid record: " + line);
                        continue;
                    }
                    System.out.printf("%-6s %-10s %d%n", fields[0], fields[1], marks);
                    total += marks;
                    count++;
                    if (marks >= 50) {
                        passed++;
                        writer.write(fields[1] + " PASS");
                    } else {
                        failed++;
                        writer.write(fields[1] + " FAIL");
                    }
                    writer.newLine();
                }
                writer.write("Passed: " + passed);
                writer.newLine();
                writer.write("Failed: " + failed);
                writer.newLine();
                writer.write(String.format("Average: %.2f", (double) total / count));
                writer.newLine();
            }
            System.out.println("result.txt created: passed " + passed + ", failed " + failed);
        } catch (IOException exception) {
            System.out.println("File error: " + exception.getMessage());
        }
    }
}
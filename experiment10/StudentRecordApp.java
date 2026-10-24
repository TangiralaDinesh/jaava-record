import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRecordApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = Db.open()) {
            boolean running = true;
            while (running) {
                System.out.println("\n1 Add  2 Search  3 Update marks  4 Delete  5 List  0 Exit");
                System.out.print("Choice: ");
                String choice = scanner.nextLine().trim();
                try {
                    switch (choice) {
                        case "1": addStudent(connection, scanner); break;
                        case "2": searchStudent(connection, scanner); break;
                        case "3": updateMarks(connection, scanner); break;
                        case "4": deleteStudent(connection, scanner); break;
                        case "5": listStudents(connection); break;
                        case "0": running = false; break;
                        default: System.out.println("Choose a listed menu option.");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Marks must be a whole number.");
                } catch (SQLException exception) {
                    System.out.println("Database operation failed: " + exception.getMessage());
                }
            }
        } catch (SQLException exception) {
            System.out.println("Could not connect to the database: " + exception.getMessage());
        }
    }

    private static void addStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Register number: ");
        String registerNumber = scanner.nextLine().trim();
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Marks: ");
        int marks = Integer.parseInt(scanner.nextLine().trim());

        String sql = "INSERT INTO student (reg_no, name, marks) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, registerNumber);
            statement.setString(2, name);
            statement.setInt(3, marks);
            statement.executeUpdate();
            System.out.println("Student added.");
        }
    }

    private static void searchStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Register number: ");
        String registerNumber = scanner.nextLine().trim();
        String sql = "SELECT reg_no, name, marks FROM student WHERE reg_no = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, registerNumber);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    printStudent(result);
                } else {
                    System.out.println("No matching student.");
                }
            }
        }
    }

    private static void updateMarks(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Register number: ");
        String registerNumber = scanner.nextLine().trim();
        System.out.print("New marks: ");
        int marks = Integer.parseInt(scanner.nextLine().trim());
        String sql = "UPDATE student SET marks = ? WHERE reg_no = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, marks);
            statement.setString(2, registerNumber);
            System.out.println(statement.executeUpdate() + " row(s) updated.");
        }
    }

    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Register number: ");
        String registerNumber = scanner.nextLine().trim();
        String sql = "DELETE FROM student WHERE reg_no = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, registerNumber);
            System.out.println(statement.executeUpdate() + " row(s) deleted.");
        }
    }

    private static void listStudents(Connection connection) throws SQLException {
        String sql = "SELECT reg_no, name, marks FROM student ORDER BY reg_no";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            System.out.printf("%-12s %-20s %s%n", "REG NO", "NAME", "MARKS");
            while (result.next()) {
                printStudent(result);
            }
        }
    }

    private static void printStudent(ResultSet result) throws SQLException {
        System.out.printf("%-12s %-20s %d%n",
                result.getString("reg_no"), result.getString("name"), result.getInt("marks"));
    }
}
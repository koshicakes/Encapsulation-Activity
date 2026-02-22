import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static final String DB_URL = "jdbc:sqlite:C:/Users/Richard/sqlite test/NetBeansProjects/Tasktas/src/students.db/";

    public Repository() {
        createTable();
    }

    private void createTable() {

        String sql = """
        CREATE TABLE IF NOT EXISTS students(
        id INTEGER PRIMARY KEY,
        lastName TEXT NOT NULL,
        firstName TEXT NOT NULL,
        middleName TEXT,
        extensionName TEXT,
        gender TEXT,
        age INTEGER,
        course TEXT,
        yearLevel INTEGER,
        address TEXT,
        contactNumber TEXT
        );
        """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void addStudent(Student s) {

        String sql = "INSERT OR REPLACE INTO students VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getFirstName());
            ps.setString(4, s.getMiddleName());
            ps.setString(5, s.getExtensionName());
            ps.setString(6, s.getGender());
            ps.setInt(7, s.getAge());
            ps.setString(8, s.getCourse());
            ps.setInt(9, s.getYearLevel());
            ps.setString(10, s.getAddress());
            ps.setString(11, s.getContactNumber());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Student s = new Student.Builder()
                        .setId(rs.getInt("id"))
                        .setLastName(rs.getString("lastName"))
                        .setFirstName(rs.getString("firstName"))
                        .setMiddleName(rs.getString("middleName"))
                        .setExtensionName(rs.getString("extensionName"))
                        .setGender(rs.getString("gender"))
                        .setAge(rs.getInt("age"))
                        .setCourse(rs.getString("course"))
                        .setYearLevel(rs.getInt("yearLevel"))
                        .setAddress(rs.getString("address"))
                        .setContactNumber(rs.getString("contactNumber"))
                        .build();

                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }

        return list;
    }
}
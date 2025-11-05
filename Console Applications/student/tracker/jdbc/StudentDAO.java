package student.tracker.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, rollNo, dept, email, mark1, mark2, mark3, mark4, mark5) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getRollNo());
            ps.setString(3, student.getDept());
            ps.setString(4, student.getEmail());

            int[] marks = student.getMarks();
            for (int i = 0; i < 5; i++) {
                ps.setInt(5 + i, marks[i]);
            }

            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int rollNo = rs.getInt("rollNo");
                String dept = rs.getString("dept");
                String email = rs.getString("email");

                int[] marks = new int[5];
                for (int i = 0; i < 5; i++) {
                    marks[i] = rs.getInt((i + 5));
                }

                list.add(new Student(name, rollNo, dept, email, marks));
            }
        }
        return list;
    }

    public boolean deleteStudent(int rollNo) throws SQLException {
        String sql = "DELETE FROM students WHERE rollNo = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, rollNo);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name=?, dept=?, email=?, mark1=?, mark2=?, mark3=?, mark4=?, mark5=? WHERE rollNo=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getDept());
            ps.setString(3, student.getEmail());

            int[] marks = student.getMarks();
            for (int i = 0; i < 5; i++) {
                ps.setInt(4 + i, marks[i]);
            }

            ps.setInt(9, student.getRollNo());

            return ps.executeUpdate() > 0;
        }
    }

    public Student getStudent(int rollNo) throws SQLException {
        String sql = "SELECT * FROM students WHERE rollNo = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String dept = rs.getString("dept");
                String email = rs.getString("email");
                int[] marks = new int[5];
                for (int i = 0; i < 5; i++) {
                    marks[i] = rs.getInt((i + 5));
                }
                return new Student(name, rollNo, dept, email, marks);
            }
        }
        return null;
    }
}


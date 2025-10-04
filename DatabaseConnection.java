import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConnection {
    protected Connection connect() {
        Connection conn = null;
        try {
            // Adjust these values to match your setup
            String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
            String user = "system";
            String password = "your_password";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
        return conn;
    }
}

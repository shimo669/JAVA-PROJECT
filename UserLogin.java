import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin extends DatabaseConnection {

    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM users WHERE username=? AND password=? AND role='user'";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isValid = true;
            }

        } catch (Exception e) {
            System.out.println("Error during user login: " + e.getMessage());
        }
        return isValid;
    }
}

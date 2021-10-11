import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;

public class testClass {

    @Test
    public void checkTableExists() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","hello123");
        Statement statement = conn.createStatement();
        String sql = "SHOW TABLES LIKE 'employees'";
        assertTrue(statement.execute(sql));
        conn.close();
    }
}

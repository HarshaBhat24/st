import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Database Connection Tests")
class DatabaseConnectionTest {

    // Database configuration constants
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static final int CONNECTION_TIMEOUT_SECONDS = 5;

    private static Connection connection;

    @BeforeAll
    static void setup() throws Exception {
        loadJdbcDriver();
        establishConnection();
    }

    @AfterAll
    static void teardown() throws SQLException {
        closeConnection();
    }

    @Test
    @DisplayName("Connection should not be null after setup")
    void testConnectionIsNotNull() {
        assertNotNull(connection, "Database connection should not be null");
    }

    @Test
    @DisplayName("Connection should be valid")
    void testConnectionIsValid() throws SQLException {
        assertTrue(
            connection.isValid(CONNECTION_TIMEOUT_SECONDS),
            "Database connection should be valid"
        );
    }

    @Test
    @DisplayName("Simple query should execute successfully")
    void testSimpleQuery() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {
            
            assertTrue(rs.next(), "Query should return at least one row");
            assertEquals(1, rs.getInt(1), "Result should be 1");
        }
    }

    // Helper methods

    private static void loadJdbcDriver() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
    }

    private static void establishConnection() throws SQLException {
        connection = DriverManager.getConnection(
            DATABASE_URL,
            DATABASE_USER,
            DATABASE_PASSWORD
        );
    }

    private static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
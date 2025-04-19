package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Liftbringer67@#";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public class TestConnection {
        public static void main(String[] args) {
            Connection conn = DbConnection.getConnection();
            if (conn != null) {
                System.out.println("Koneksi berhasil!");
            } else {
                System.out.println("Koneksi gagal!");
            }
        }
    }
    

    public static void main(String[] args) {
        Connection conn = DbConnection.getConnection();
        System.out.println("Cek koneksi: " + (conn != null ? "✅ Berhasil terhubung ke database!" : "❌ Gagal terhubung ke database."));
    }
    
}

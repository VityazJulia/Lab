package connector;


import java.sql.*;

public class DBConnector {
    private String url = "jdbc:mysql://localhost:3306/MySQL";
    private String user = "root_";
    private String password = "pass";
    private Connection connection;

    public DBConnector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            return this.connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean isConnected() {
        try {
            return !this.connection.isClosed();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
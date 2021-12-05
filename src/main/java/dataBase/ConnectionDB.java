package dataBase;

import java.sql.*;

public class ConnectionDB {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "3264300892";
    private static final String CONNECTIONURL = "jdbc:mysql://localhost:3306/plant";

    private Connection connection;

    public ConnectionDB() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}

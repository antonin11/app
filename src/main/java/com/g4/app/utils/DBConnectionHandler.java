package com.g4.app.utils;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by antoninpedotti on 25/05/2016.
 */
public class DBConnectionHandler {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:8889/gappg4";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    private Connection connection = null;

    public DBConnectionHandler() {
        java.sql.Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }
        throw new SQLException("You are not connected !");
    }
}

package io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWriter {

    public static String mysql = "jdbc:mysql://localhost:3306/";
    public static String user = "root";
    public static String pwd = "hello123";

    public static void createDatabase(String dataPath){
        // Create database
        try (Connection conn = DriverManager.getConnection(mysql+dataPath, user, pwd)){
            conn.setAutoCommit(false);
                Statement statement = conn.createStatement();
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS employees");
                conn.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createTable(String name, String dataPath){
        try (Connection conn = DriverManager.getConnection(mysql+dataPath)){
            Statement statement = conn.createStatement();
            statement.execute("");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

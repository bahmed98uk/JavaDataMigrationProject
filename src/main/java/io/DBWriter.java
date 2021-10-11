package io;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class DBWriter {

    private static final String SQL_TRUNCATE = "TRUNCATE employees";
    private static final String SQL_INSERT = "INSERT INTO employees (EmpID, NamePrefix, FirstName, MiddleInitial, LastName, Gender, Email, DateofBirth, DateofJoining, Salary) VALUES(?,?,?,?,?,?,?,?,?,?)";
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

    public static void createTable(String dataPath){
        try (Connection conn = DriverManager.getConnection(mysql+dataPath, user, pwd)){
            Statement statement = conn.createStatement();
            statement.execute("create table if not exists employees\n" +
                    "(\n" +
                    "\tEmpID int null,\n" +
                    "\tNamePrefix VARCHAR(255) null,\n" +
                    "\tFirstName VARCHAR(255) null,\n" +
                    "\tMiddleInitial CHAR null,\n" +
                    "\tLastName VARCHAR(255) null,\n" +
                    "\tGender CHAR null,\n" +
                    "\tEmail VARCHAR(255) null,\n" +
                    "\tDateofBirth VARCHAR(255) null,\n" +
                    "\tDateofJoining VARCHAR(255) null,\n" +
                    "\tSalary int null\n" +
                    ");\n" +
                    "\n");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertData(String dataPath, ArrayList<Employee> employees){
        try (Connection conn = DriverManager.getConnection(mysql+dataPath, user, pwd)){
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
            Statement statement = conn.createStatement();
            statement.executeUpdate(SQL_TRUNCATE);

            for(int i=0; i < employees.size(); i++){
                ps.setInt(1, employees.get(i).getId());
                ps.setString(2, employees.get(i).getPrefix());
                ps.setString(3, employees.get(i).getFirstName());
                ps.setString(4, String.valueOf(employees.get(i).getInitial()));
                ps.setString(5, employees.get(i).getLastName());
                ps.setString(6, String.valueOf(employees.get(i).getGender()));
                ps.setString(7, employees.get(i).getEmail());
                ps.setString(8, String.valueOf(employees.get(i).getDob()));
                ps.setString(9, String.valueOf(employees.get(i).getDoj()));
                ps.setInt(10, employees.get(i).getSalary());
                ps.executeUpdate();
            }
            ps.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

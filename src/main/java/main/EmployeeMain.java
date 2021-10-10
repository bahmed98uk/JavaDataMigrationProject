package main;

import io.*;
import model.Employee;
import java.util.ArrayList;

public class EmployeeMain {
    public static void main(String[] args) {

        final String dbPath = "employees";
        final String employeeTable = "employees";
        ArrayList<Employee> employeesList = new ArrayList<>();

        DBWriter.createDatabase(dbPath);
        DBWriter.createTable(dbPath);
        CSVReader.CSVRead(employeesList);
        DBWriter.insertData(dbPath, CSVReader.CSVRead(employeesList));

    }
}

package io;

import control.DataHandler;
import model.Employee;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class CSVReader{

    public static ArrayList<Employee> CSVRead(ArrayList<Employee> empList){
        String line = null;

        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"));
             BufferedWriter out = new BufferedWriter(new FileWriter("EmployeeOutput.txt"))) {
                 String headerLine = in.readLine();
                 out.write(headerLine);
                 while((line = in.readLine()) != null) {
                     empList.add(DataHandler.employeePopulate(line));
                     out.newLine();
                     out.write(line);
                 }
        }  catch(IOException | ParseException e){
                 e.printStackTrace();
        }
        DataHandler.employeeListDuplicateChecker(empList);
        return empList;
    }
}

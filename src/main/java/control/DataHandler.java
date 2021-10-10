package control;

import model.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class DataHandler {

    public static Date dateFormat(String date) throws ParseException{

        java.util.Date dateOriginal = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        java.util.Date dateNew = new java.sql.Date(dateOriginal.getTime());
        return dateNew;
    }

    public static boolean isValid(String data){
        boolean valid = true;
        String[] empList = data.split(",");
        if (Integer.valueOf(empList[0]) < 0)
            valid = false;
        if (empList[1].length() > 5 || !empList[1].matches("[a-zA-Z]+\\."))
            valid = false;
        if (empList[2].length() > 256 || !empList[2].matches("\\p{L}+"))
            valid = false;
        if (!empList[3].substring(0,1).matches("[a-zA-Z]+"))
            valid = false;
        if (empList[4].length() > 256 || !empList[4].matches("\\p{L}+"))
            valid = false;
        if (!empList[5].matches("[FMfm]"))
            valid = false;
        if (!empList[6].matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
            valid = false;
        if (!empList[7].matches("(0?[1-9]|1[0-2])[\\/?$](0?[1-9]|[12]\\d|30|31)[\\/?$](\\d{4}|\\d{2})"))
            valid = false;
        if (!empList[8].matches("(0?[1-9]|1[0-2])[\\/?$](0?[1-9]|[12]\\d|30|31)[\\/?$](\\d{4}|\\d{2})"))
            valid = false;
        if (Integer.valueOf(empList[9]) < 0)
            valid = false;
        return valid;
    }

    public static Employee employeePopulate(String data) throws ParseException{
        String[] empList = data.split(",");
        if(!isValid(data)){
            System.err.println("The data is not valid");
            System.exit(1);
        }
        Employee emp = new Employee(Integer.valueOf(empList[0]), empList[1], empList[2], empList[3].charAt(0),
                empList[4], empList[5].charAt(0), empList[6], dateFormat(empList[7]),
                dateFormat(empList[8]), Integer.valueOf(empList[9]));
        return emp;
    }

    public static void employeeListDuplicateChecker(ArrayList<Employee> data) {
        HashSet<Employee> uniqueElements = new HashSet<>(data);
        int nSize = uniqueElements.size();
        int oSize = data.size();
        data.clear();
        data.addAll(uniqueElements);
        int dupAmount = oSize - nSize;
        System.out.println("Original number of employee entries: " + oSize + '\n' +
                "Valid employee entries: " + nSize + '\n' +
                "Number of duplicate entries: " + dupAmount);
    }
}

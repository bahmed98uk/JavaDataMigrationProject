package model;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private Integer id, salary;
    private String prefix, firstName, lastName, email;
    private char initial, gender;
    private Date dob, doj;

    public Employee(Integer id, String prefix, String fName, char initial, String lName,
                    Date dob, Date doj, Integer salary) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getInitial() {
        return initial;
    }

    public void setInitial(char initial) {
        this.initial = initial;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return initial == employee.initial && gender == employee.gender && Objects.equals(id, employee.id) && Objects.equals(salary, employee.salary) && Objects.equals(prefix, employee.prefix) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(dob, employee.dob) && Objects.equals(doj, employee.doj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, prefix, firstName, lastName, email, initial, gender, dob, doj);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", initial=" + initial +
                ", gender=" + gender +
                ", dob=" + dob +
                ", doj=" + doj +
                '}';
    }
}

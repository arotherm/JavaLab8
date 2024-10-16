package com.example.demomidtermtest;

import java.util.Date;
import java.util.regex.Pattern;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date hireDate;
    private String jobCode;
    private int salary;

    public Employee(int employeeId, String firstName, String lastName, String phoneNumber, Date hireDate, String jobCode, int salary) {
        setEmployeeId(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setHireDate(hireDate);
        setJobCode(jobCode);
        setSalary(salary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Canot be negative or 0");
        }
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() <= 1) {
            throw new IllegalArgumentException("Frst name must be more than 1 character or not blankk.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() <= 1) {
            throw new IllegalArgumentException("Last Name has to eb bigger than 1 characters");
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String regex = "^(\\+1|1)?\\d{10}$";
        if (!Pattern.matches(regex, phoneNumber)) {
            throw new IllegalArgumentException("Please put a valid phone num. ");
        }
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        if (hireDate == null || hireDate.after(new Date())) {
            throw new IllegalArgumentException("Hire date cannot be in the future.");
        }
        this.hireDate = hireDate;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        String regex = "^[A-Z]+_[A-Z]+$"; //my Attempt at having ALPHA+'_'+ALPHA
        if (!Pattern.matches(regex, jobCode)) {
            throw new IllegalArgumentException("Job code must be all capital letters with one underscore.");
        }
        this.jobCode = jobCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
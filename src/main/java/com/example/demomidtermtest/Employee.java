package com.example.demomidtermtest;

import java.util.Date;
import java.util.regex.Pattern;
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String hireDate;
    private String jobCode;

    // Constructor
    public Employee(Integer employeeId, String firstName, String lastName, String phoneNumber, Date hireDate, String jobCode) {
        setEmployeeId(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
        setHireDate(hireDate);
        setPhoneNumber(phoneNumber);
        setJobCode(jobCode);
    }

    // Getters and Setters with validation
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be a positive integer.");
        }
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() <= 1) {
            throw new IllegalArgumentException("First name must be more than 1 character.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() <= 1) {
            throw new IllegalArgumentException("Last name must be more than 1 character.");
        }
        this.lastName = lastName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        // Assuming the hireDate is in the format "yyyy-MM-dd", more advanced date parsing could be added.
        if (hireDate == null || !Pattern.matches("\\d{4}-\\d{2}-\\d{2}", hireDate.toString())) {
            throw new IllegalArgumentException("Hire date must be in the format 'yyyy-MM-dd'.");
        }
        this.hireDate = hireDate.toString();

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}[- .]?\\d{3}[- .]?\\d{4}")) {
            throw new IllegalArgumentException("Phone number must have dots between numbers (e.g., 123.456.7890).");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        if (!jobCode.matches("[A-Z]+_[A-Z]+")) {
            throw new IllegalArgumentException("Jb code must be all uppercase letters with one underscore.");
        }
        this.jobCode = jobCode;
    }

}
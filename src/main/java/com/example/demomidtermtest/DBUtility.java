package com.example.demomidtermtest;

import java.util.ArrayList;
import java.sql.*;

public class DBUtility {
    private static String user="student";
    private static String password="student";
    private static String connectionURL="jdbc:mysql://localhost:3306/javatest";

    /*
    *To Do: Update this method to get all or filtered Employees from the database
    * */
    public static ArrayList<Employee> getEmployees(String... sql) throws SQLException {

        ArrayList<Employee> employees = new ArrayList<>();
        String query = "select * from employee";
        try(Connection conn= DriverManager.getConnection(connectionURL,user,password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);) {

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String jobCode = resultSet.getString("jobCode");
                Date hireDate = resultSet.getDate("hireDate");

                Employee employee = new Employee(employeeId, firstName, lastName, phoneNumber, hireDate, jobCode);
                employees.add(employee);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    /*
     *To Do: Update this method to get the area codes for the combo Box list
     * */
    public static ArrayList<String> getAreaCodes()
    {
        ArrayList<String> areaCodes = new ArrayList<>();
        areaCodes.add("905");
        areaCodes.add("647");
        areaCodes.add("416");
        return areaCodes;
    }

    /*
     *To Do: Update this method to get the area codes for the combo Box list
     * */
    public static ArrayList<Employee> filterEmployees(boolean isSenior, boolean isIT, String areaCode ) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        String query = "select * from employee where ";
        if (isSenior) {
            query += "job_code = 'Senior' ";
        }
        if (isIT) {
            query += "job_code = 'IT' ";
        }
        if (areaCode != null) {
            query += "phone_number like '%" + areaCode + "%'";
        }
        try(Connection conn= DriverManager.getConnection(connectionURL,user,password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);) {

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                String jobCode = resultSet.getString("job_code");
                Date hireDate = resultSet.getDate("hire_date");

                Employee employee = new Employee(employeeId, firstName, lastName, phoneNumber, hireDate, jobCode);
                employees.add(employee);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

}

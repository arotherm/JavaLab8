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
    public static ArrayList<Employee> getEmployees(boolean isSenior, boolean isIT, String areaCode) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        // I decided to start the query with a stringbuilder starting with SELECT * FROM WHERE1=1.
        // employee and appending AND clauses. I had to use WHERE since my filtering wasnt working. Next time I learned to start with WHERE 1=1
        //as an always true clause
        StringBuilder query = new StringBuilder("SELECT * FROM employee WHERE 1=1");

        if (isSenior) {
            query.append(" AND hireDate <= DATE_SUB(CURDATE(), INTERVAL 10 YEAR)");
        }
        if (isIT) {
            query.append(" AND jobCode = 'IT_PROG'");
        }
        /*if area code is 905, then the query should be "SELECT * FROM employee WHERE phoneNumber LIKE '905-%'"*/
        if (areaCode != null && areaCode.equals("515")) {
            query.append(" AND phoneNumber LIKE '515%'");
        }
        /*if area code is 647, then the query should be "SELECT * FROM employee WHERE phoneNumber LIKE '647-%'"*/
        if (areaCode != null && areaCode.equals("590")) {
            query.append(" AND phoneNumber LIKE '590%'");
        }
        /*if area code is 416, then the query should be "SELECT * FROM employee WHERE phoneNumber LIKE '416-%'"*/
        if (areaCode != null && areaCode.equals("650")) {
            query.append(" AND phoneNumber LIKE '650%'");
        }




        // Debugging: Print the generated SQL query
        System.out.println("Executing query: " + query.toString());

        try (Connection conn = DriverManager.getConnection(connectionURL, user, password);
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(query.toString())) {

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
        } catch (SQLException e) {
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
        areaCodes.add("515");
        areaCodes.add("590");
        areaCodes.add("650");
        areaCodes.add("All");
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

}

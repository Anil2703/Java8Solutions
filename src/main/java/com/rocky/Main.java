package com.rocky;

import com.rocky.model.Employee;

import java.util.Arrays;
import java.util.List;

import static com.rocky.util.EmployeeUtil.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = buildEmployees();

        List<Employee> activeEmployees = getAllActiveEmployees(employees);

        System.out.println("Toal no. of Active Employees: " +activeEmployees.size() );
        System.out.println("List of Active Employees:" +activeEmployees);

        List<String> allcompanyEmployeeNames = getAllEmployeeNames(employees);
        System.out.println("List of all Company's Employees: "+ allcompanyEmployeeNames);

        List<Employee> sortedEmployeesbySalaryDescending = sortEmployeesbySalaryDescending(employees);
        System.out.println("Employees Sorted by salary in Descending: "+ sortedEmployeesbySalaryDescending);

        if (isAnyEmployeeFromHR(employees)) {
            System.out.println("There is at least one employee from HR department.");
        } else {
            System.out.println("No employees from HR department.");
        }


        System.out.println("Employees by Department:: " +groupEmployeesbyDepartment(employees));

        System.out.println("Employees Count by Department:: " +countEmployeesbyDepartment(employees));

        System.out.println("All Department Names:: "+ getAllDepartmentNames(employees));

        System.out.println("Highest Salaried Employee:: " + getHighestSalariedEmployee(employees));
        System.out.println("Second Highest Salaried Employee:: " + getSecondHighestSalariedEmployee(employees));


        System.out.println("Lowest Salaried Employee:: " + getLowestSalariedEmployee(employees));
        System.out.println("Second Lowest Salaried Employee:: " + getSecondLowestSalariedEmployee(employees));

        System.out.println("Top 3 Highest Salaried Employees:: " + getTop3HighestSalariedEmployees(employees));

        System.out.println("Highest Salaried Employee by Department:: " + getHighestPaidEmployeeByDepartment(employees));

        System.out.println("Sorted by salaries in each Department:: " + sortEmployeesBySalaryInEachDepartment(employees));

    }

    public static List<Employee> buildEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", "Manager", 75000, 35, "alice@x.com", "12345", "NY", true),
                new Employee(2, "Bob", "IT", "Developer", 85000, 28, "bob@x.com", "12346", "LA", true),
                new Employee(3, "Charlie", "Finance", "Analyst", 65000, 30, "charlie@x.com", "12347", "TX", false),
                new Employee(4, "David", "IT", "Developer", 90000, 25, "david@x.com", "12348", "WA", true),
                new Employee(5, "Eva", "Marketing", "Executive", 60000, 29, "eva@x.com", "12349", "FL", true),
                new Employee(6, "Frank", "HR", "Executive", 55000, 32, "frank@x.com", "12350", "NY", false),
                new Employee(7, "Grace", "Finance", "Manager", 95000, 38, "grace@x.com", "12351", "IL", true),
                new Employee(8, "Hank", "IT", "Lead", 100000, 40, "hank@x.com", "12352", "CA", true),
                new Employee(9, "Ivy", "IT", "Developer", 87000, 27, "ivy@x.com", "12353", "WA", true),
                new Employee(10, "Jack", "Marketing", "Manager", 72000, 34, "jack@x.com", "12354", "TX", false)
        );

        return employees;
    }
}

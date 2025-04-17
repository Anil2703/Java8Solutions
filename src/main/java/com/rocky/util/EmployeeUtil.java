package com.rocky.util;

import com.rocky.model.Employee;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeUtil {

    // Get all active employees
    public static List<Employee> getAllActiveEmployees(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.isActive())
                .collect(Collectors.toList());
    }

    //Get a list of employee names
    public static List<String> getAllEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
    }

    //Sort employees by salary descending
    public static List<Employee> sortEmployeesbySalaryDescending(List<Employee> employees) {
        return employees.stream()
                //.sorted(Comparator.comparing(Employee::getSalary).reversed())
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    //Check if any employee is from HR
    public static boolean isAnyEmployeeFromHR(List<Employee> employees) {
        return employees.stream()
                .anyMatch(employee -> StringUtils.equals(employee.getDepartment(), "HR"));
    }

    public static Map<String, List<Employee>> groupEmployeesbyDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static Map<String, Long> countEmployeesbyDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    //Print the names of all departments in the organization.
    public static List<String> getAllDepartmentNames(List<Employee> employees) {
        return employees.stream().map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    //Employee with highest salary
    public static Optional<Employee> getHighestSalariedEmployee(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(0)
                .findFirst();
    }

    //Employee with 2nd highest salary
    public static Optional<Employee> getSecondHighestSalariedEmployee(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
    }

    //Employee with lowest salary
    public static Optional<Employee> getLowestSalariedEmployee(List<Employee> employees) {


        //return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst();

        // This is another way to find the employee with the lowest salary
        // by using min() instead of sorting and finding the first element.
        // This is more efficient than sorting the entire list.
        // It directly finds the minimum based on the salary.
        return employees.stream()
                .min(Comparator.comparingDouble((Employee::getSalary)));

    }

    //Employee with 2nd highest salary
    public static Optional<Employee> getSecondLowestSalariedEmployee(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .skip(1)
                .findFirst();
    }

    //Print the top 3 highest salary earned employees
    public static List<Employee> getTop3HighestSalariedEmployees(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    //Find highest paid salary in the organisation based on department.
    public static Map<String, Optional<Employee>> getHighestPaidEmployeeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    //Sort the employees salary in each department in ascending order
    public static Map<String, List<Employee>> sortEmployeesBySalaryInEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(e -> e, Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary))
                                .collect(Collectors.toList())));
    }


}

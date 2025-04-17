package com.rocky.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String designation;
    private double salary;
    private int age;
    private String email;
    private String phone;
    private String address;
    private boolean active;

    // Constructor
    public Employee(int id, String name, String department, String designation,
                    double salary, int age, String email, String phone,
                    String address, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = active;
    }

    // Getters (add only the ones you need for simplicity)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public boolean isActive() { return active; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }
}

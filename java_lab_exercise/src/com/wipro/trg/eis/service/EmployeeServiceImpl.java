package com.wipro.trg.eis.service;

import java.util.Scanner;

import com.wipro.trg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Employee getEmployeeDetails() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter Employee Designation: ");
        String designation = scanner.nextLine();

        return new Employee(id, name, salary, designation);
    }

    @Override
    public void findInsuranceScheme(Employee employee) {
        employee.setInsuranceScheme(employee.getInsuranceScheme());
    }

    @Override
    public void displayEmployeeDetails(Employee employee) {
        System.out.println(employee);
    }
}
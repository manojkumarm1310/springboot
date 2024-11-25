package com.cg.eis.pl;

import com.wipro.trg.eis.bean.Employee;
import com.wipro.trg.eis.service.EmployeeService;
import com.wipro.trg.eis.service.EmployeeServiceImpl;

public class Main  {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();

        Employee employee = employeeService.getEmployeeDetails();

        employeeService.findInsuranceScheme(employee);

        employeeService.displayEmployeeDetails(employee);
    }
}
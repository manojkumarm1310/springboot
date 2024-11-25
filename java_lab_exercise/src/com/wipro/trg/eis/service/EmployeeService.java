package com.wipro.trg.eis.service;



import com.wipro.trg.eis.bean.Employee;



public interface EmployeeService {

    Employee getEmployeeDetails();

    void findInsuranceScheme(Employee employee);

    void displayEmployeeDetails(Employee employee);

}
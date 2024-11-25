package com.sapient.trg.eis.service;

import com.sapient.trg.eis.bean.Employee;

public interface EmployeeService {
    Employee getEmployeeDetails();
    void findInsuranceScheme(Employee employee);
    void displayEmployeeDetails(Employee employee);
}

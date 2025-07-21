package com.example.demo.Service;

import java.util.List;

import com.example.demo.Domain.Employee;

public interface EmployeeServ {
    Employee getEmpById(String empId);
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee emp);
    boolean deleteEmployee(String empId);
} 


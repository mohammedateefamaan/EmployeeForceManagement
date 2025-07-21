package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Employee;
import com.example.demo.Repository.EmployeeRepo;

@Service
public class EmployeeServImpl implements EmployeeServ {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

 @Override
public Employee saveEmployee(Employee emp) {
    if (employeeRepo.findById(emp.getEmployeeId()).isPresent()) {
        throw new IllegalArgumentException("Employee with ID " + emp.getEmployeeId() + " already exists.");
    }

    return employeeRepo.save(emp);
}
@Override
public boolean deleteEmployee(String empId) {
    if (employeeRepo.findById(empId).isEmpty()) {
        throw new IllegalArgumentException("Employee Not Present to delete...");
    }

    employeeRepo.deleteById(empId);
    return true;
}

@Override
public Employee getEmpById(String empId) {
    return employeeRepo.getReferenceById(empId);
}
}

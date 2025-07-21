// package com.example.demo.Controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.Domain.Employee;
// import com.example.demo.Service.EmployeeServ;

// @RestController
// @RequestMapping("/apic/v9")
// public class EmployeeController {

//     @Autowired
//     private EmployeeServ employeeServ;

//     // Get all employees
//     @GetMapping
//     public ResponseEntity<List<Employee>> getAllEmployees() {
//         List<Employee> employees = employeeServ.getAllEmployees();
//         return ResponseEntity.ok(employees);
//     }

//     // Get employee by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
//         Employee employee = employeeServ.getEmpById(id);
//         return ResponseEntity.ok(employee);
//     }

//     // Save a new employee
//     @PostMapping("/createEmployee")
//     public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {
//         try {
//             Employee savedEmployee = employeeServ.saveEmployee(employee);
//             return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//         } catch (Exception ex) {
//             return new ResponseEntity<>("Problem in controller: " + ex.getMessage(), HttpStatus.CONFLICT);
//         }
//     }
//     // Delete employee
//     @DeleteMapping("/deleteEmployee/{id}")
//     public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
//         try {
//             boolean deleted = employeeServ.deleteEmployee(id);
//             if (deleted) {
//                 return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
//             } else {
//                 return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
//             }
//         } catch (Exception ex) {
//             return new ResponseEntity<>("Error deleting employee: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }
// }


package com.example.demo.Controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Domain.Employee;
import com.example.demo.Service.EmployeeServ;


@RestController
@RequestMapping("/apic/v9")
public class EmployeeController {

    @Autowired
    private EmployeeServ employeeServ;

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServ.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.ok(employees);
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
    Employee employee = employeeServ.getEmpById(id);
    // Initialize any lazy-loaded fields to avoid proxy issues
    Hibernate.initialize(employee);
    return ResponseEntity.ok(employee);
}

    // Save a new employee
    @PostMapping("/createEmployee")
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeServ.saveEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Problem in controller: " + ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    // Delete employee
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        try {
            boolean deleted = employeeServ.deleteEmployee(id);
            if (deleted) {
                return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting employee: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

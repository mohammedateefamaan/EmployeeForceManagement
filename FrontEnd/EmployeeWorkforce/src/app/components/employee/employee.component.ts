// import { Component, OnInit } from '@angular/core';
// import { EmployeeService } from '../../services/employee.service';
// import { Employee } from '../../models/employee';


// @Component({
//   selector: 'app-employee',
//   standalone: true,
//   imports: [],
//   templateUrl: './employee.component.html',
//   styleUrl: './employee.component.css'
// })

// export class EmployeeComponent implements OnInit {
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employees: Employee[] = [];
  selectedEmployee?: Employee;
  newEmployee: Employee = {};

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employees = data;
    });
  }

  getEmployeeDetails(employeeId: string): void {
    this.employeeService.getEmployeeById(employeeId).subscribe(data => {
      this.selectedEmployee = data;
    });
  }

  addEmployee(): void {
    this.employeeService.createEmployee(this.newEmployee).subscribe(() => {
      this.loadEmployees();
      this.newEmployee = {};
    });
  }

  deleteEmployee(employeeId: string): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(() => {
      this.loadEmployees();
    });
  }
}

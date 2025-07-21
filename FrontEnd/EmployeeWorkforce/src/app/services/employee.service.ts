import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:8081/apic/v9';

  constructor(private http: HttpClient) {}

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}`);
  }

  getEmployeeById(employeeId: string): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/${employeeId}`);
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.baseUrl}/createEmployee`, employee);
  }

  deleteEmployee(employeeId: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteEmployee/${employeeId}`);
  }
}

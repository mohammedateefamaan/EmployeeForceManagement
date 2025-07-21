// import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';

// @Component({
//   selector: 'app-root',
//   standalone: true,
//   imports: [RouterOutlet],
//   templateUrl: './app.component.html',
//   styleUrl: './app.component.css'
// })
// export class AppComponent {
//   title = 'EmployeeWorkforce';
// }


import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeComponent } from './components/employee/employee.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, EmployeeComponent],
  template: `<app-employee></app-employee>`,
})
export class AppComponent {}



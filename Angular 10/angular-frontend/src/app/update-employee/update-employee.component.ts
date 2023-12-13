import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent {

  id!:number;
  employee: Employee = new Employee();
constructor(private employeeService: EmployeeService, private route: ActivatedRoute,
  private router: Router) { }

ngOnInit():void{
  this.id=this.route.snapshot.params['id'];
  this.employeeService.getEmployeeId(this.id).subscribe({
    next: (data) => {
      console.log(data)
      this.employee = data
    },
    error: (error) => console.log(error),
    complete: () => console.log("Data init completed!")
  })
}

onSubmit(){
  this.updateEmployee();
  
}

updateEmployee(){
  this.employeeService.updateEmployee(this.id, this.employee)
    .subscribe({
      next: (data) => console.log(data),
      error: (error) => console.log(error),
      complete: () => this.goToEmployeeList()
    })
}

goToEmployeeList(){
  this.router.navigate(['/employees'])}; 
}


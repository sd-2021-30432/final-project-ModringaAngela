import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-create-user-account',
  templateUrl: './create-user-account.component.html',
  styleUrls: ['./create-user-account.component.css']
})
export class CreateUserAccountComponent implements OnInit {

  constructor(private clientService: LoginService) { }

  ngOnInit(): void {
  }

  
  createUser(userForm: NgForm): void{

    let date = new Date(userForm.value.dob);

    this.clientService.createAccount(userForm.value.firstName, userForm.value.lastName,
      userForm.value.username, userForm.value.password, date).subscribe(
        data => {
          alert("Done");
          userForm.reset();
          window.location.reload();
        }, 
        error => {
          alert("Username already used");
          userForm.reset();
          window.location.reload();
        }
      );
  }

}

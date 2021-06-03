import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import { Client } from '../entities/Client';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  client: Client;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {
  }

  onSubmit(loginForm: NgForm): void{

    this.loginService.login(loginForm.value.username, loginForm.value.password).subscribe(
      data => {
        this.client = data;
        this.setUpClient(this.client);
        this.router.navigate([`/client/${this.client.id}`]);
        return true;
      },
      error =>{
        alert("Wrong credidentials!");
      });

      loginForm.reset();
  }

  setUpClient(client: Client):void{
    sessionStorage.setItem('client', JSON.stringify(client));
  }
}

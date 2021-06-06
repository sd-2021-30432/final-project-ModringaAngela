import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Client } from '../../entities/Client';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-create-bank-account',
  templateUrl: './create-bank-account.component.html',
  styleUrls: ['./create-bank-account.component.css']
})
export class CreateBankAccountComponent implements OnInit {

  client: Client;

  constructor(private accountService:AccountService) { }


  ngOnInit(): void {
    this.client = JSON.parse(sessionStorage.getItem("client"));
  }

  createAccount(accountForm: NgForm): void{
    this.accountService.createAccount(accountForm.value.bankName, accountForm.value.type,
      accountForm.value.balance, accountForm.value.iban, this.client.id).subscribe(
        data => {
          alert("Done");
          accountForm.reset();
          window.location.reload();
        }, 
        error => {
          alert("Something went wrong");
          accountForm.reset();
          window.location.reload();
        }
      );
  }

}

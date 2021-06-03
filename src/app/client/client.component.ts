import { Component, OnInit } from '@angular/core';
import { Client } from '../entities/Client';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../services/account.service';
import { BankAccount } from '../entities/BankAccount';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  client: Client;
  accounts: BankAccount[];

  constructor(private route: ActivatedRoute,  private router: Router, private accountService: AccountService) { }

  ngOnInit(): void {
    this.client=JSON.parse(sessionStorage.getItem("client"));

    this.route.paramMap.subscribe(() =>{
      this.getAccounts();
    })
  }

  getAccounts(){
    this.accountService.getAccountsByClientId(this.client.id).subscribe(
      data => {
        this.accounts = data;
      }
    )
  }
  
  viewAccount(account: BankAccount):void{
    this.accountService.seeAccount(account);
  }

}

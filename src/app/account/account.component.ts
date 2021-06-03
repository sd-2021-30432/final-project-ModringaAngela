import { Component, OnInit } from '@angular/core';
import { DepositService } from '../services/deposit.service';
import { BankAccount } from '../entities/BankAccount';
import { AccountService } from '../services/account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  account: BankAccount;
  constructor(private accountService: AccountService, private depositService: DepositService, private router: Router) { }

  ngOnInit(): void {
    this.account = JSON.parse(sessionStorage.getItem('account'));
  }

  seeDeposits(account: BankAccount):void{
   this.router.navigate([`/deposits`]);
  }
}

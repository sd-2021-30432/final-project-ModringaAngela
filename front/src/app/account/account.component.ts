import { Component, OnInit } from '@angular/core';
import { DepositService } from '../services/deposit.service';
import { BankAccount } from '../entities/BankAccount';
import { AccountService } from '../services/account.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  account: BankAccount;
  constructor(private accountService: AccountService, private depositService: DepositService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.account = JSON.parse(localStorage.getItem('account'));
    this.route.paramMap.subscribe(() => {
      this.getAccount(this.account.id);
    })
  }


  getAccount(id: number){
    this.accountService.getAccountById(id).subscribe(
      data => {
        this.account = data;
      }
    )
  }

  seeDeposits(account: BankAccount):void{
    this.router.navigate([`/deposits`]);
   }


  seeCards(account: BankAccount):void{
   this.router.navigate([`/cards`]);
  }

  makeTransfer(account: BankAccount):void{
    this.router.navigate([`/transfer`]);
   }

   payBill(account: BankAccount):void{
    this.router.navigate([`/pay-bill`]);
   }

   createDeposit(account: BankAccount):void{
    this.router.navigate([`/create-deposit`]);
   }

   

}

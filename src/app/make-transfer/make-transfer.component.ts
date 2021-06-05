import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BankAccount } from '../entities/BankAccount';
import { Client } from '../entities/Client';
import { AccountService } from '../services/account.service';
import { TransferService } from '../services/transfer.service';

@Component({
  selector: 'app-make-transfer',
  templateUrl: './make-transfer.component.html',
  styleUrls: ['./make-transfer.component.css']
})
export class MakeTransferComponent implements OnInit {

  accountFrom: BankAccount;
  client: Client;
  accounts: BankAccount[];

  constructor(private transferService: TransferService, private router: Router, private route: ActivatedRoute, private accountService: AccountService) { }

  ngOnInit(): void {
    this.accountFrom = JSON.parse(localStorage.getItem("account"));
    this.client = JSON.parse(sessionStorage.getItem("client"));
    
    this.route.paramMap.subscribe(()=> {
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

 internalTransfer(transferForm1: NgForm): void{

    this.transferService.makeTransferInternal(transferForm1.value.accountToId, transferForm1.value.amountOfMoney, this.accountFrom.id).subscribe(
      data => {
        alert("Done");
        transferForm1.reset();
        window.location.reload();
      }, 
      error => {
        alert("Error");
        transferForm1.reset();
        window.location.reload();
      }
    );
  }

 externalTransfer(transferForm2: NgForm): void{

    this.transferService.makeTransferExternal(transferForm2.value.iban, transferForm2.value.amountOfMoney, this.accountFrom.id).subscribe(
      data => {
        alert("Done");
        transferForm2.reset();
        window.location.reload();
      }, 
      error => {
        alert("Error");
        transferForm2.reset();
        window.location.reload();
      }
    );

  }


}

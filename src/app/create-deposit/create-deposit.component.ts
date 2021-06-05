import { DepositService } from '../services/deposit.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BankAccount } from '../entities/BankAccount';
import { Client } from '../entities/Client';
import { AccountService } from '../services/account.service';



@Component({
  selector: 'app-create-deposit',
  templateUrl: './create-deposit.component.html',
  styleUrls: ['./create-deposit.component.css']
})
export class CreateDepositComponent implements OnInit {

  accountFrom: BankAccount;

  constructor(private depositService: DepositService, private router: Router, private route: ActivatedRoute, private accountService: AccountService) { }

  ngOnInit(): void {
    this.accountFrom = JSON.parse(localStorage.getItem("account"));
  }

  createDeposit(depositForm: NgForm): void{

    this.depositService.createDeposit(depositForm.value.amountOfMoney, depositForm.value.period, this.accountFrom.id).subscribe(
      data => {
        alert("Done");
        depositForm.reset();
        window.location.reload();
      }, 
      error => {
        alert("The deposit couldn t be made");
        depositForm.reset();
        window.location.reload();
      }
    );
  }


}

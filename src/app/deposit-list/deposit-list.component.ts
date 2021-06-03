import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BankAccount } from '../entities/BankAccount';
import { Deposit } from '../entities/Deposit';
import { DepositService } from '../services/deposit.service';

@Component({
  selector: 'app-deposit-list',
  templateUrl: './deposit-list.component.html',
  styleUrls: ['./deposit-list.component.css']
})
export class DepositListComponent implements OnInit {

  deposits: Deposit[];
  account: BankAccount;

  constructor(private route: ActivatedRoute, private depositService: DepositService) { }

  ngOnInit(): void {

    this.account = JSON.parse(sessionStorage.getItem('account'));

    this.route.paramMap.subscribe(()=>{
      this.listDeposits();
    })

  }

  listDeposits(){
    this.depositService.getDepositsByAccountId(this.account.id).subscribe(
      data => {
        this.deposits = data;
      }
    )
  }
}

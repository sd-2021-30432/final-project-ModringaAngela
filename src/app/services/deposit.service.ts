import { Deposit } from '../entities/Deposit';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BankAccount } from '../entities/BankAccount';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class DepositService {

  private basicUrl: string;
  constructor(private http :HttpClient, private router: Router) { 
    this.basicUrl = 'http://localhost:8080';
  }
  public getDepositsByAccountId(id: number): Observable<Deposit[]>{
    return this.http.get<Deposit[]>(this.basicUrl + `/account/${id}/deposits`);
  }

  public createDeposit(amountOfMoney: number, period:number, accountId: number):Observable<any>{
    const deposit: Deposit = new Deposit();
    deposit.accountId = accountId;
    deposit.period = period;
    deposit.amountOfMoney = amountOfMoney;

    return this.http.post(this.basicUrl + `/create-deposit`, deposit);

  }

  public destroyDeposit(depositId: number):Observable<any>{
    return this.http.delete(this.basicUrl + `/delete-deposit/${depositId}`);
  }
}

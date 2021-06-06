import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BankAccount } from '../entities/BankAccount';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private basicUrl: string;
  constructor(private http :HttpClient, private router: Router) { 
    this.basicUrl = 'http://localhost:8080';
  }

  public getAccountsByClientId(id: number): Observable<BankAccount[]>{
    return this.http.get<BankAccount[]>(this.basicUrl + `/client/${id}/accounts`);
  }

  public seeAccount(account: BankAccount){
    localStorage.setItem('account', JSON.stringify(account));
    this.router.navigate([`/account/${account.id}`]);
  }

  public getAccountById(id: number): Observable<any>{
    return this.http.get<BankAccount>(this.basicUrl + `/account/${id}`);
  }

  public createAccount(bankName:string, type:string , balance:number, iban:string, id: number): Observable<any>{
   
    const account: BankAccount = new BankAccount();

    account.bankName = bankName;
    account.type = type;
    account.balance = balance;
    account.iban = iban;
    account.clientId = id;

    console.log("new acc");

    console.log(account.clientId);
    console.log(account.bankName);

    return this.http.post(this.basicUrl + `/accounts/add-account`, account);
  }
}

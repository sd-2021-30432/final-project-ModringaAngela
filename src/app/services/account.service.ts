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
    sessionStorage.setItem('account', JSON.stringify(account));
    this.router.navigate([`/account/${account.id}`]);
  }
}

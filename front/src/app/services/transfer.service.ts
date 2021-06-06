
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Transfer } from '../entities/Transfer';
@Injectable({
  providedIn: 'root'
})
export class TransferService {

  private basicUrl: string;
  constructor(private http :HttpClient, private router: Router) { 
    this.basicUrl = 'http://localhost:8080';
  }
  
  public makeTransferInternal(accountToId: number, amountOfMoney: number, accountFromId: number):Observable<any>{

    const transfer: Transfer = new Transfer();
    transfer.amountOfMoney = amountOfMoney;
    transfer.accountFromId = accountFromId;
    transfer.accountToId = accountToId;
    transfer.iban = null;

    console.log(transfer.accountToId);
    return this.http.put(this.basicUrl + `/make-transfer-internal`, transfer);
  }

  public makeTransferExternal(iban: string, amountOfMoney: number, accountFromId: number):Observable<any>{

    const transfer: Transfer = new Transfer();
    transfer.iban = iban;
    transfer.amountOfMoney = amountOfMoney;
    transfer.accountFromId = accountFromId;
    transfer.accountToId = null;

    return this.http.put(this.basicUrl + `/make-transfer-external`, transfer);
  }

}

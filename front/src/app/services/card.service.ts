import { Card } from '../entities/Card';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  private basicUrl: string;
  constructor(private http :HttpClient, private router: Router) { 
    this.basicUrl = 'http://localhost:8080';
  }
  public getCardsByAccountId(id: number): Observable<Card[]>{
    return this.http.get<Card[]>(this.basicUrl + `/account/${id}/cards`);
  }
}

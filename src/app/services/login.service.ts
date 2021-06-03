import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Client } from '../entities/Client';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;
  private baseUrl: string;

  constructor(private http: HttpClient) { 
    this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem("currentUser")));
    this.currentUser = this.currentUserSubject.asObservable();
    this.baseUrl = 'http://localhost:8080';
  }

  public get currentUserValue() {
    return this.currentUserSubject.value;
  }

  public login(username: string, password: string):Observable<any>{
    const c: Client = new Client();
    c.username = username;
    c.password = password;
    return this.http.post(this.baseUrl + `/login-client`, c);
  }
}

import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LogInComponent} from './log-in/log-in.component';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import { ClientComponent } from './client/client.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AccountComponent } from './account/account.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DepositListComponent } from './lists/deposit-list/deposit-list.component';
import { CreateDepositComponent } from './operations/create-deposit/create-deposit.component';
import { CardsListComponent } from './lists/cards-list/cards-list.component';
import { MakeTransferComponent } from './operations/make-transfer/make-transfer.component';
import { CreateBankAccountComponent } from './operations/create-bank-account/create-bank-account.component';
import { CreateUserAccountComponent } from './operations/create-user-account/create-user-account.component';

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    HomeComponent,
    ClientComponent,
    AccountComponent,
    DepositListComponent,
    CreateDepositComponent,
    CardsListComponent,
    MakeTransferComponent,
    CreateBankAccountComponent,
    CreateUserAccountComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomeComponent
      },
      {
        path: 'login',
        component: LogInComponent
      },
      {
        path:'client/:id',
        component:ClientComponent
      }, 
      {
        path:'account/:id',
        component:AccountComponent
      }, 
      {
        path: 'deposits',
        component:DepositListComponent
      }, 
      {
        path: 'cards',
        component:CardsListComponent   
      },
      {
        path: 'transfer', 
        component: MakeTransferComponent
      },
      {
        path: 'create-deposit',
        component: CreateDepositComponent
      }, {
        path: 'register-account',
        component:CreateBankAccountComponent
      }, {
        path:'register',
        component:CreateUserAccountComponent
      }
    ])
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

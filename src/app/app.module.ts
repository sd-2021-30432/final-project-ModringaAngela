import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LogInComponent} from './log-in/log-in.component';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {PartnersListComponent} from './partners-list/partners-list.component';
import { ClientComponent } from './client/client.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AccountComponent } from './account/account.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DepositListComponent } from './deposit-list/deposit-list.component';
import { CreateDepositComponent } from './create-deposit/create-deposit.component';
import { CardsListComponent } from './cards-list/cards-list.component';
import { MakeTransferComponent } from './make-transfer/make-transfer.component';
import { PayBillComponent } from './pay-bill/pay-bill.component';

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
    PayBillComponent,
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
        path: 'partners',
        component: PartnersListComponent
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
      }, {
        path: 'pay-bill', 
        component: PayBillComponent
      }, 
      {
        path: 'create-deposit',
        component: CreateDepositComponent
      }
    ])
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

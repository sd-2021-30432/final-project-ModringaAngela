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

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    HomeComponent,
    ClientComponent,
    AccountComponent,
    DepositListComponent,
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
      }
    ])
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

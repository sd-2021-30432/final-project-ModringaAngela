import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BankAccount } from '../entities/BankAccount';
import { Card } from '../entities/Card';
import { CardService } from '../services/card.service';

@Component({
  selector: 'app-cards-list',
  templateUrl: './cards-list.component.html',
  styleUrls: ['./cards-list.component.css']
})
export class CardsListComponent implements OnInit {

  cards: Card[];
  account: BankAccount;

  constructor(private route: ActivatedRoute, private cardService: CardService) { }

  ngOnInit(): void {

    this.account = JSON.parse(localStorage.getItem('account'));

    this.route.paramMap.subscribe(()=>{
      this.listCards();
    })

  }

  listCards(){
    this.cardService.getCardsByAccountId(this.account.id).subscribe(
      data => {
        this.cards = data;
      }
    )
  }

}

import { Component } from '@angular/core';
import { Difficulty } from '../../types/difficulty.type';
import { GameServiceService } from '../../services/game-service.service';

@Component({
  selector: 'app-endgame',
  standalone: true,
  imports: [],
  templateUrl: './endgame.component.html',
  styleUrl: './endgame.component.css'
})
export class EndgameComponent {

  userName!:string;
  userEmail!:string;
  userScore!:number;
  win!:boolean;
  difficulty!:Difficulty;

  constructor(private gameService:GameServiceService){
    this.userName = this.gameService.getUserName();
    this.userEmail = this.gameService.getUserEmail();
    this.userScore = this.gameService.getUserScore();
    this.win = this.gameService.getWin();
    this.difficulty = this.gameService.getDifficulty();
  }
}

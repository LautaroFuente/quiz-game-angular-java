import { Component } from '@angular/core';
import { GameServiceService } from '../../services/game-service.service';
import { ScoresServiceService } from '../../services/scores-service.service';
import { Router } from '@angular/router';
import { Difficulty } from '../../types/difficulty.type';

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [],
  templateUrl: './game.component.html',
  styleUrl: './game.component.css'
})
export class GameComponent {

  userName!:string;
  userEmail!:string;
  userScore!:number;
  win!:boolean;
  difficulty!:Difficulty;

  constructor( private gameService: GameServiceService, private scoreService: ScoresServiceService, private router: Router){
    this.userName = this.gameService.getUserName();
    this.userEmail = this.gameService.getUserEmail();
    this.userScore = this.gameService.getUserScore();
    this.win = this.gameService.getWin();
    this.difficulty = this.gameService.getDifficulty();
  }

  game():void{
    
  }

  endgame():void{

    this.scoreService.saveScore(this.userName, this.userEmail, this.userScore, this.win, this.difficulty);
    this.router.navigate(['/endgame']);
  }
}

import { Component, OnInit } from '@angular/core';
import { Difficulty } from '../../types/difficulty.type';
import { GameServiceService } from '../../services/game-service.service';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-endgame',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './endgame.component.html',
  styleUrl: './endgame.component.css',
})
export class EndgameComponent implements OnInit{
  userName!: string;
  userEmail!: string;
  userScore!: number;
  win!: boolean;
  difficulty!: Difficulty;

  constructor(private gameService: GameServiceService, private router:Router) {}

  ngOnInit(): void {
    this.userName = this.gameService.getUserName();
    this.userEmail = this.gameService.getUserEmail();
    this.userScore = this.gameService.getUserScore();
    this.win = this.gameService.getWin();
    this.difficulty = this.gameService.getDifficulty();
  }

  backMenu(){
    this.gameService.reset();
    this.router.navigate(["/"]);
  }

  toScore(){
    this.gameService.reset();
    this.router.navigate(["/scores"]);
  }
}

import { Component, OnInit } from '@angular/core';
import { GameServiceService } from '../../services/game-service.service';
import { Router } from '@angular/router';
import { Difficulty } from '../../types/difficulty.type';

@Component({
  selector: 'app-select-difficulty',
  standalone: true,
  imports: [],
  templateUrl: './select-difficulty.component.html',
  styleUrl: './select-difficulty.component.css'
})
export class SelectDifficultyComponent implements OnInit {

  userName!:string;

  constructor(private gameService:GameServiceService, private router:Router){}

  ngOnInit(): void {
    this.userName = this.gameService.getUserName();
  }

  setDifficulty(difficulty:Difficulty):void{
    this.gameService.setDifficulty(difficulty);
    this.router.navigate(["/game"]);
  }
}

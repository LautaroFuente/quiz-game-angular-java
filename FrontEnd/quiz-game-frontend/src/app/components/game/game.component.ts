import { Component } from '@angular/core';
import { GameServiceService } from '../../services/game-service.service';
import { ScoresServiceService } from '../../services/scores-service.service';
import { Router } from '@angular/router';
import { Difficulty } from '../../types/difficulty.type';
import { Question } from '../../interfaces/Question.interface';
import { QuestionsServiceService } from '../../services/questions-service.service';
import { AnswersServiceService } from '../../services/answers-service.service';
import { Answer } from '../../interfaces/Answer.interface';

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
  questions!:Question[];
  answersPosibilities!:Answer[]; 
  index:number = 0;

  constructor( private gameService: GameServiceService, private scoreService: ScoresServiceService, private router: Router, 
  private questionService: QuestionsServiceService, private answersService: AnswersServiceService){

    this.userName = this.gameService.getUserName();
    this.userEmail = this.gameService.getUserEmail();
    this.userScore = this.gameService.getUserScore();
    this.win = this.gameService.getWin();
    this.difficulty = this.gameService.getDifficulty();
    this.questionService.getQuestions(this.difficulty).subscribe(
      (response) => {
        console.log('Informacion obtenida', response);
        this.questions = response;
      },
      (error) => console.log(`Error`, error)
    );
  }

  game():void{
    

  }

  getAnswersForTheQuestion():void{
    this.answersService.getAnswers(this.questions[this.index].id).subscribe(
      (response) => {
        console.log('Informacion obtenida', response);
        this.answersPosibilities = response;
      },
      (error) => console.log(`Error`, error)
    );
  }

  endgame():void{

    this.scoreService.saveScore(this.userName, this.userEmail, this.userScore, this.win, this.difficulty);
    this.router.navigate(['/endgame']);
  }
}

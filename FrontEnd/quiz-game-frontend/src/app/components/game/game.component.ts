import { Component, OnDestroy } from '@angular/core';
import { GameServiceService } from '../../services/game-service.service';
import { ScoresServiceService } from '../../services/scores-service.service';
import { Router } from '@angular/router';
import { Difficulty } from '../../types/difficulty.type';
import { Question } from '../../interfaces/Question.interface';
import { QuestionsServiceService } from '../../services/questions-service.service';
import { AnswersServiceService } from '../../services/answers-service.service';
import { Answer } from '../../interfaces/Answer.interface';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [],
  templateUrl: './game.component.html',
  styleUrl: './game.component.css'
})
export class GameComponent implements OnDestroy{

  userName!:string;
  userEmail!:string;
  userScore!:number;
  win!:boolean;
  difficulty!:Difficulty;
  questions!:Question[];
  answersPosibilities!:Answer[]; 
  index:number = 0;
  time:number = 60;

  private unsubscribe$ = new Subject<void>();

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
    this.loadAnswers();
  }

  game():void{

    setTimeout(() => {
      this.time = this.time - 1;
      if(this.time == 0){
        //endgame
      }
    }, 1000);    

  }

  onClickOption( answer: Answer):void{
    if(answer.correct){
      this.time += 10;
      this.userScore += 10;
    }
    else{
      this.time -= 5;
    }

    this.index += 1;
    this.loadAnswers();
  }

  loadAnswers():void{
    this.getAnswersForTheQuestion();
  }

  getAnswersForTheQuestion():void{
    this.answersService.getAnswers(this.questions[this.index].id).pipe(
      takeUntil(this.unsubscribe$)
    ).subscribe(
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

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}

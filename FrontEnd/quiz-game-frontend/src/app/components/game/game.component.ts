import { Component, OnDestroy, OnInit } from '@angular/core';
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
export class GameComponent implements OnDestroy, OnInit{

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

  constructor( 
    private gameService: GameServiceService, 
    private scoreService: ScoresServiceService, 
    private router: Router, 
    private questionService: QuestionsServiceService, 
    private answersService: AnswersServiceService)
    {}

  ngOnInit(): void {
    this.userName = this.gameService.getUserName();
    this.userEmail = this.gameService.getUserEmail();
    this.userScore = this.gameService.getUserScore();
    this.win = this.gameService.getWin();
    this.difficulty = this.gameService.getDifficulty();
    this.questionService.getQuestions(this.difficulty).pipe(takeUntil(this.unsubscribe$)).subscribe(
      (response) => {
        console.log('Informacion obtenida', response);
        this.questions = response;
      },
      (error) => console.log(`Error`, error)
    );
    this.game();
    this.loadAnswers();
  }

  game():void{

    const timer = setInterval(() => {
      this.time -= 1;
  
      if (this.time <= 0) {
          clearInterval(timer);
          this.endgame();
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

    if(this.index == 9){
      this.endgame();
    }else{
      this.index += 1;
      this.loadAnswers();
    }  
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
    if(this.time > 0){
      this.win = true;
    }
    this.scoreService.saveScore(this.userName, this.userEmail, this.userScore, this.win, this.difficulty);
    this.router.navigate(['/endgame']);
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}

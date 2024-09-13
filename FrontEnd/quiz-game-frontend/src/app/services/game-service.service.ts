import { Injectable } from '@angular/core';
import { Difficulty } from '../types/difficulty.type';

@Injectable({
  providedIn: 'root'
})
export class GameServiceService {

  userName:string = "Invitado";
  userEmail:string = "invitado@gmail.com";
  userScore:number = 0;
  win:boolean = false;
  difficulty:Difficulty = "easy";

  constructor() { }

  reset():void{
    this.userName = "Invitado";
    this.userEmail = "invitado@gmail.com";
    this.userScore = 0;
    this.win = false;
    this.difficulty = "easy";
  }

  getUserName(): string{
    return this.userName;
  }

  setUserName(userName:string): void{
    this.userName = userName;
  }

  getUserEmail(): string{
    return this.userEmail;
  }

  setUserEmail(userEmail:string): void{
    this.userEmail = userEmail;
  }

  getUserScore(): number{
    return this.userScore;
  }

  setUserScore(userScore:number): void{
    this.userScore = userScore;
  }

  getWin(): boolean{
    return this.win;
  }

  setWin(win:boolean): void{
    this.win = win;
  }

  getDifficulty(): Difficulty{
    return this.difficulty;
  }

  setDifficulty(difficulty:Difficulty): void{
    this.difficulty = difficulty;
  }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Difficulty } from '../types/difficulty.type';

@Injectable({
  providedIn: 'root',
})
export class ScoresServiceService {
  private apiUrl = 'http://localhost:8080/api/score';

  constructor(private http: HttpClient) {}

  getScores(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.http.get<any>(this.apiUrl, { headers });
  }

  saveScore(
    userName: string,
    userEmail: string,
    userScore: number,
    win: boolean,
    difficulty: Difficulty
  ): Observable<any> {
    const data = { userName, userEmail, userScore, win, difficulty };

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.http.post(this.apiUrl, data, { headers });
  }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Difficulty } from '../types/difficulty.type';

@Injectable({
  providedIn: 'root'
})
export class QuestionsServiceService {

  private apiUrl = 'http://localhost:8080/api/question';

  constructor( private httpClient: HttpClient) { }

  getQuestions( difficulty: Difficulty ) : Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.httpClient.get<any>(`${this.apiUrl}?difficulty=${difficulty}`, { headers });
  }
}

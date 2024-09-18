import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnswersServiceService {

  private apiUrl = 'http://localhost:8080/api/answers';

  constructor( private httpClient: HttpClient) { }

  getAnswers( questionId: number ) : Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.httpClient.get<any>(`${this.apiUrl}?questionId=${questionId}`, { headers });
  }

}

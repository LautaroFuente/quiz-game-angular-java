import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class RegisterServiceService {
  private apiUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) {}

  getUsers(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.http.get<any>(this.apiUrl, { headers });
  }

  saveUser(userName: string, userEmail: string): Observable<any> {
    const url = 'http://localhost:8080/api/users';
    const data = { userName, userEmail };

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.http.post(url, data, { headers });
  }
}

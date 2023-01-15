import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {

  private getAllLecturersUrl: string = 'http://localhost:8080/lecturers/';

  constructor(private http: HttpClient) {}

  getAllLecturers() {
    return this.http.get<any>(this.getAllLecturersUrl);
  }

}

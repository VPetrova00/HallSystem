import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {ILecturerDetails} from "../interfaces/ILecturerDetails";

@Injectable({
  providedIn: 'root',
})
export class RegistrationService {

  private addLecturersUrl: string = 'http://localhost:8080/registration/lecturer/register';

  constructor(private http: HttpClient) {}

  addLecturer(lecturer: ILecturerDetails): void {
    this.http.post<ILecturerDetails>(this.addLecturersUrl, lecturer).subscribe();
  }

}

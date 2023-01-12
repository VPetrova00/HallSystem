import { IHallInfo } from './../interfaces/IHallInfo';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MyReservationsService {
  constructor(private http: HttpClient) {}

  getReservations(name: string): Observable<IHallInfo[]> {
    return this.http.get<IHallInfo[]>(
      'http://localhost:8080/halls/lecturer/' + 'Ivan' + '/reservedHalls'
    );
  }
}

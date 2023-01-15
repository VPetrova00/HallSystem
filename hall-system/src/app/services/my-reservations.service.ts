import {IHallInfo} from './../interfaces/IHallInfo';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ILecturerDetails} from "../interfaces/ILecturerDetails";
import {formatDate} from "@angular/common";

@Injectable({
  providedIn: 'root',
})
export class MyReservationsService {
  constructor(private http: HttpClient) {
  }

  getReservations(name: string): Observable<IHallInfo[]> {
    return this.http.get<IHallInfo[]>(
      'http://localhost:8080/halls/lecturer/' + name + '/reservedHalls'
    );
  }

  deleteReservation(id: number, lecturerId: number, reservedHour: number, reservedDate: Date): void {
    this.http.delete('http://localhost:8080/lecturers/' + lecturerId + '/deleteReservation/' + id + '?reservedHour=' + reservedHour + '&reservedDate=' + formatDate(reservedDate, 'dd.MM.yyyy', 'en_US')).subscribe();
  }

  getLecturerByName(name: string): Observable<ILecturerDetails> {
    return this.http.get<ILecturerDetails>('http://localhost:8080/lecturers/' + name);
  }
}

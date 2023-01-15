import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IHall} from "../interfaces/IHall";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class HallsService {
  constructor(private httpClient: HttpClient) {}

  getAllHalls(): Observable<IHall[]> {
    return this.httpClient.get<IHall[]>('http://localhost:8080/halls/all');
  }

  getDetailsForAHall(id: number): Observable<IHall> {
    return this.httpClient.get<IHall>('http://localhost:8080/halls/' + id);
  }

  getFreeIntervalsHallById(id: number | null, date: string) {
    if(id != null) {
      return this.httpClient.get<number[]>('http://localhost:8080/halls/freeIntervals/hall/' + id + '?date=' + date);
    }

    return null;
  }

  getReservedHoursHallById(id: number | null, date: string) {
    if(id != null) {
      return this.httpClient.get<number[]>('http://localhost:8080/halls/reservedHours/hall/' + id + '?date=' + date);
    }

    return null;
  }
}

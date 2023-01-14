import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IHall} from "../interfaces/IHall";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class HallsService {
  constructor(private httpClient: HttpClient) {}

  getAllHals(): Observable<IHall[]> {
    return this.httpClient.get<IHall[]>('http://localhost:8080/halls/all');
  }

  getDetailsForAHall(id: number): Observable<IHall> {
    return this.httpClient.get<IHall>('http://localhost:8080/halls/' + id);
  }
}

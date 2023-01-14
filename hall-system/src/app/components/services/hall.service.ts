import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {HallInterface} from "../models/hall.model";

@Injectable({
  providedIn: 'root'
})
export class HallService {
  getAllHallsUrl: string = "http://localhost:8080/hall/all";
  getHallUrlById: string = "http://localhost:8080/hall";
  getReservedHallsUrl: string = "http://localhost:8080/hall/lecturer";
  getFreeIntervalsHallUrlById: string = "http://localhost:8080/hall/freeIntervals";

  constructor(
    private http: HttpClient
  ) {}

  getAllHalls() {
    return this.http.get<any>(this.getAllHallsUrl);
  }

  getHallById(id: number | null) {
    if(id != null) {
      let finalUrl = this.getHallUrlById + id;
      return this.http.get<any>(finalUrl);
    }

    return null;
  }

  getReservedHalls(name: string | null) {
    if(name) {
      let finalUrl = this.getReservedHallsUrl + name;
      return this.http.get<any>(finalUrl);
    }

    return null;
  }

  getFreeIntervalsHallById(id: number | null) {
    if(id != null) {
      let finalUrl = this.getFreeIntervalsHallUrlById + id;
      return this.http.get<any>(finalUrl);
    }

    return null;
  }

}

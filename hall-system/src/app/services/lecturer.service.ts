import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class LecturerService {
  constructor(private httpClient: HttpClient) {}

  reserveHall(lecturerId: number, hallId: number, startingHour: number, reservedDate: string) {
    return this.httpClient.post('http://localhost:8080/lecturers/' + lecturerId + '/reserve/' + hallId + '/' + startingHour + '?reservationDate=' + reservedDate, null).subscribe();
  }

}

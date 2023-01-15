import { Component, OnInit } from '@angular/core';
import {HallsService} from "../../services/halls.service";
import {LecturerService} from "../../services/lecturer.service";
import {IHall} from "../../interfaces/IHall";
import {Router} from "@angular/router";

@Component({
  selector: 'app-hall-reservation',
  templateUrl: './hall-reservation.component.html',
  styleUrls: ['./hall-reservation.component.scss']
})
export class HallReservationComponent implements OnInit {
  public halls!: IHall[];
  public selectedHall!: IHall;
  public selectedDate!: string;
  public freeStartingIntervals!: number[];
  public freeEndingIntervals!: number[];
  public selectedStartingHour: number | undefined;
  public selectedEndingHour: number | undefined;
  public canMakeReservation: boolean = true;
  public isThereOtherReservation: boolean = false;
  public reservedHours!: number[];

  constructor(private hallService: HallsService, private lecturesService: LecturerService, private router: Router) {
    this.hallService.getAllHalls().subscribe((res => {
      this.halls = res;
    }));
  }

  ngOnInit(): void {
    if (localStorage.length == 0) {
      this.router.navigate(['/login']);
    }

    this.setTomorrowDate();
  }

  setTomorrowDate() {
    var currentDate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
    var day = currentDate.getDate()
    var month = (currentDate.getMonth() + 1) / 10 < 1 ? '0'+(currentDate.getMonth() + 1) : (currentDate.getMonth() + 1);
    var year = currentDate.getFullYear()

    this.selectedDate = year + '-' + month + '-' + day;

  }

  getFreeIntervals() {
    this.hallService.getFreeIntervalsHallById(this.selectedHall.id, this.convertDate(this.selectedDate))?.subscribe((data) => {
      this.freeStartingIntervals = data;
      this.freeEndingIntervals = data.map(el => el + 1);
      this.selectedStartingHour = undefined;
      this.selectedEndingHour = undefined;

      this.hallService.getReservedHoursHallById(this.selectedHall.id, this.convertDate(this.selectedDate))?.subscribe((data) => {
        this.reservedHours = data;
      })

    })
  }

  convertDate(selectedDate: string) {
    var date = selectedDate.toString().split('-');
    var day = date[2];
    var month = date[1];
    var year = date[0];
    return [day,month,year].join('.');
  }

  checkForReservationAbility(): boolean {
    if (!this.selectedHall || !this.selectedEndingHour || !this.selectedEndingHour) {
      this.canMakeReservation = false;
      return false;
    } else if ((this.selectedStartingHour && this.selectedEndingHour)&&(this.selectedEndingHour <= this.selectedStartingHour)) {
      return false;
    }
    else {
      this.canMakeReservation = true;
      return true;
    }
  }

  checkForOverlapping(): boolean {
    for (var i=this.selectedStartingHour!;i<this.selectedEndingHour!;i++) {
      if (this.reservedHours.includes(i)) {
        this.isThereOtherReservation = true;
        break;
      } else {
        this.isThereOtherReservation = false;
      }
    }
    return this.isThereOtherReservation;
  }

  reserve() {
    if (this.checkForReservationAbility() && !this.checkForOverlapping()) {
      for (var i = this.selectedStartingHour!; i < this.selectedEndingHour!; i++) {
        this.lecturesService.reserveHall(Number(localStorage.getItem('id')), this.selectedHall.id, i, this.convertDate(this.selectedDate))
      }

      this.router.navigate(['pages/myReservations']).then(() => {
        window.location.reload();
      });
    }
  }
}

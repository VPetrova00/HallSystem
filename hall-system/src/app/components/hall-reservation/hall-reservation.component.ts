import { Component, OnInit } from '@angular/core';
import {HallService} from "../services/hall.service";

@Component({
  selector: 'app-hall-reservation',
  templateUrl: './hall-reservation.component.html',
  styleUrls: ['./hall-reservation.component.scss']
})
export class HallReservationComponent implements OnInit {
  public halls: any;

  constructor(private hallService: HallService) { }

  ngOnInit(): void {
    this.hallService.getAllHalls().subscribe((res => this.halls = res));
  }



}

import { IHallInfo } from './../../interfaces/IHallInfo';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-reservations',
  templateUrl: './my-reservations.component.html',
  styleUrls: ['./my-reservations.component.scss'],
})
export class MyReservationsComponent implements OnInit {
  displayedColumns: string[] = ['number', 'photo', 'actions'];
  dataSource!: IHallInfo[];

  constructor(private router: Router) {}

  ngOnInit(): void {}
}

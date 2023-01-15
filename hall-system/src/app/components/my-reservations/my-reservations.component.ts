import { IHallInfo } from './../../interfaces/IHallInfo';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyReservationsService } from 'src/app/services/my-reservations.service';
import { ILecturerDetails } from '../../interfaces/ILecturerDetails';

@Component({
  selector: 'app-my-reservations',
  templateUrl: './my-reservations.component.html',
  styleUrls: ['./my-reservations.component.scss'],
})
export class MyReservationsComponent implements OnInit {
  displayedColumns: string[] = [
    'hallNumber',
    'facultyName',
    'reservedDate',
    'reservedHour',
    'actions',
  ];
  dataSource!: IHallInfo[];

  constructor(private router: Router, private service: MyReservationsService) {}

  ngOnInit(): void {
    let storageData = JSON.parse(
      localStorage.getItem('lecturer') || '{}'
    ).lecturer;
    if (!storageData) {
      this.router.navigate(['/login']);
    }
    this.service.getReservations(storageData).subscribe((data) => {
      this.dataSource = data;
    });
  }

  deleteReservation(id: any, reservedHour: any, reservedDate: any): void {
    this.service.deleteReservation(
      id,
      Number(localStorage.getItem('id')),
      reservedHour,
      reservedDate
    );

    window.location.reload();
  }
}

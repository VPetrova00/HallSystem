import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {IHall} from "../../../interfaces/IHall";
import {HallsService} from "../../../services/halls.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  hallInformation!: IHall[];

  constructor(private router: Router, private service: HallsService) { }

  ngOnInit(): void {
    this.service.getAllHals().subscribe((data) => {
      this.hallInformation = data;
    });
  }

  logout() {
    this.router.navigate(['../']);
  }
}

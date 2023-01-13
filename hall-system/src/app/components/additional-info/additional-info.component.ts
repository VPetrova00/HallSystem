import {Component, Input, OnInit} from "@angular/core";
import {HallsService} from "../../services/halls.service";
import {IHall} from "../../interfaces/IHall";

@Component({
  selector: 'additional-info',
  templateUrl: 'additional-info.component.html',
  styleUrls: ['additional-info.component.scss']
})
export class AdditionalInfoComponent implements OnInit {
  @Input() id!: number;
  details!: IHall;

  constructor(private service: HallsService) {
  }

  ngOnInit(): void {
    this.service.getDetailsForAHall(this.id).subscribe((details) => {
      this.details = details;
    });
  }
}

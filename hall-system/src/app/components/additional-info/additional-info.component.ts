import { Component, OnInit } from "@angular/core";
import { IDetails } from "../../interfaces/IDetails";

@Component({
  selector: 'additional-info',
  templateUrl: 'additional-info.component.html',
  styleUrls: ['additional-info.component.scss']
})
export class AdditionalInfoComponent implements OnInit {
  tableColumns: string[] = ['computer_hall', 'projector', 'capacity'];

  //test object
  row: IDetails = {
    computer_hall: "не",
    projector: "да",
    capacity: 100,
  };
  details: IDetails[] = [this.row];

  constructor() {
  }

  ngOnInit(): void {
  }
}

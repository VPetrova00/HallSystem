export interface HallInterface {
  id: number;
  capacity: number;
  facultyName: string;
  hallNumber: number;
  hasProjector: boolean;
  isComputerHall: boolean;
}

export class Hall implements HallInterface {
  id: number = 0;
  capacity: number = 0;
  facultyName: string = '';
  hallNumber: number = 0;
  hasProjector: boolean = false;
  isComputerHall: boolean = false;

  constructor(facultyName: string, capacity: number, hallNumber: number, hasProjector: boolean, isComputerHall: boolean, id?: number) {
    if(id) this.id = id;
    this.facultyName = facultyName;
    this.capacity = capacity;
    this.hallNumber = hallNumber;
    this.hasProjector = hasProjector;
    this.isComputerHall = isComputerHall;
  }

}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HallReservationComponent } from './hall-reservation.component';

describe('HallReservationComponent', () => {
  let component: HallReservationComponent;
  let fixture: ComponentFixture<HallReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HallReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HallReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

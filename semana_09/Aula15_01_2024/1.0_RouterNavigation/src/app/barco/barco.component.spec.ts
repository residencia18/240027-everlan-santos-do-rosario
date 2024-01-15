import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarcoComponent } from './barco.component';

describe('BarcoComponent', () => {
  let component: BarcoComponent;
  let fixture: ComponentFixture<BarcoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarcoComponent]
    });
    fixture = TestBed.createComponent(BarcoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

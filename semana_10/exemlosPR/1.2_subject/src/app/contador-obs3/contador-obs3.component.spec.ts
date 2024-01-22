import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContadorObs3Component } from './contador-obs3.component';

describe('ContadorObs3Component', () => {
  let component: ContadorObs3Component;
  let fixture: ComponentFixture<ContadorObs3Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContadorObs3Component]
    });
    fixture = TestBed.createComponent(ContadorObs3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

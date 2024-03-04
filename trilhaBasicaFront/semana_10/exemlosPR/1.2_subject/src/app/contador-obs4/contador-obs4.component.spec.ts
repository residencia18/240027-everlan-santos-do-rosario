import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContadorObs4Component } from './contador-obs4.component';

describe('ContadorObs4Component', () => {
  let component: ContadorObs4Component;
  let fixture: ComponentFixture<ContadorObs4Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContadorObs4Component]
    });
    fixture = TestBed.createComponent(ContadorObs4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

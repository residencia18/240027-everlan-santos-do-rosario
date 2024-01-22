import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Contador2Component } from './contador2.component';

describe('Contador2Component', () => {
  let component: Contador2Component;
  let fixture: ComponentFixture<Contador2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Contador2Component]
    });
    fixture = TestBed.createComponent(Contador2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AviaoComponent } from './aviao.component';

describe('AviaoComponent', () => {
  let component: AviaoComponent;
  let fixture: ComponentFixture<AviaoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AviaoComponent]
    });
    fixture = TestBed.createComponent(AviaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControleDePesoComponent } from './controle-de-peso.component';

describe('ControleDePesoComponent', () => {
  let component: ControleDePesoComponent;
  let fixture: ComponentFixture<ControleDePesoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ControleDePesoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ControleDePesoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

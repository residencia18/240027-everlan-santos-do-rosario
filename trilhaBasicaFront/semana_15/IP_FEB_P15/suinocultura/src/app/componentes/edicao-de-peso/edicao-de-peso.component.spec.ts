import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicaoDePesoComponent } from './edicao-de-peso.component';

describe('EdicaoDePesoComponent', () => {
  let component: EdicaoDePesoComponent;
  let fixture: ComponentFixture<EdicaoDePesoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EdicaoDePesoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EdicaoDePesoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

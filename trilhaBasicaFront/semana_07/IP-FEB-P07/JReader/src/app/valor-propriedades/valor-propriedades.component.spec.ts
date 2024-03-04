import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorPropriedadesComponent } from './valor-propriedades.component';

describe('ValorPropriedadesComponent', () => {
  let component: ValorPropriedadesComponent;
  let fixture: ComponentFixture<ValorPropriedadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ValorPropriedadesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ValorPropriedadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

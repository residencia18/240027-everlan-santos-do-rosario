import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroDePesoComponent } from './cadastro-de-peso.component';

describe('CadastroDePesoComponent', () => {
  let component: CadastroDePesoComponent;
  let fixture: ComponentFixture<CadastroDePesoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastroDePesoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CadastroDePesoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

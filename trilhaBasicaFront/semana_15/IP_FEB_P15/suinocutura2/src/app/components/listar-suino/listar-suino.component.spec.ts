import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSuinoComponent } from './listar-suino.component';

describe('ListarSuinoComponent', () => {
  let component: ListarSuinoComponent;
  let fixture: ComponentFixture<ListarSuinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarSuinoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarSuinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

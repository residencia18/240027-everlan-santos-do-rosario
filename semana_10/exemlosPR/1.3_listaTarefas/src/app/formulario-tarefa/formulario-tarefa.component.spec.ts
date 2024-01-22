import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioTarefaComponent } from './formulario-tarefa.component';

describe('FormularioTarefaComponent', () => {
  let component: FormularioTarefaComponent;
  let fixture: ComponentFixture<FormularioTarefaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormularioTarefaComponent]
    });
    fixture = TestBed.createComponent(FormularioTarefaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

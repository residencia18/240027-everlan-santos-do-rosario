import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCommumComponent } from './form-commum.component';

describe('FormCommumComponent', () => {
  let component: FormCommumComponent;
  let fixture: ComponentFixture<FormCommumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormCommumComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormCommumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

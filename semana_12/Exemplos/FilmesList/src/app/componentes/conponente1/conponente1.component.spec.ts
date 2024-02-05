import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Conponente1Component } from './conponente1.component';

describe('Conponente1Component', () => {
  let component: Conponente1Component;
  let fixture: ComponentFixture<Conponente1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Conponente1Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Conponente1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

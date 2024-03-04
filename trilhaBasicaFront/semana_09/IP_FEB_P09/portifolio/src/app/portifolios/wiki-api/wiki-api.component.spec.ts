import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WikiAPIComponent } from './wiki-api.component';

describe('WikiAPIComponent', () => {
  let component: WikiAPIComponent;
  let fixture: ComponentFixture<WikiAPIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WikiAPIComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WikiAPIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

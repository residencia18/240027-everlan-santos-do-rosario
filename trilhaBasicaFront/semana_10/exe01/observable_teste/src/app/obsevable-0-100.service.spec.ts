import { TestBed } from '@angular/core/testing';

import { Obsevable0100Service } from './obsevable-0-100.service';

describe('Obsevable0100Service', () => {
  let service: Obsevable0100Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Obsevable0100Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

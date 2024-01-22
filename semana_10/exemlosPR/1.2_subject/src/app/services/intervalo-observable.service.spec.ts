import { TestBed } from '@angular/core/testing';

import { IntervaloObservableService } from './intervalo-observable.service';

describe('IntervaloObservableService', () => {
  let service: IntervaloObservableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IntervaloObservableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ExemplosObservableService } from './exemplos-observable.service';

describe('ExemplosObservableService', () => {
  let service: ExemplosObservableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExemplosObservableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

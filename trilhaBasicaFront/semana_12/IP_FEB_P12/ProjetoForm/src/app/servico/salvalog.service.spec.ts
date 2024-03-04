import { TestBed } from '@angular/core/testing';

import { SalvalogService } from './salvalog.service';

describe('SalvalogService', () => {
  let service: SalvalogService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalvalogService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

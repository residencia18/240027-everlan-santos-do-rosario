import { TestBed } from '@angular/core/testing';

import { DataBasenService } from './data-basen.service';

describe('DataBasenService', () => {
  let service: DataBasenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DataBasenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { IntervaloSubjectService } from './intervalo-subject.service';

describe('IntervaloSubjectService', () => {
  let service: IntervaloSubjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IntervaloSubjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { BuscaPaisesService } from './busca-paises.service';

describe('BuscaPaisesService', () => {
  let service: BuscaPaisesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuscaPaisesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { BuscaArtigosService } from './busca-artigos.service';

describe('BuscaArtigosService', () => {
  let service: BuscaArtigosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuscaArtigosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

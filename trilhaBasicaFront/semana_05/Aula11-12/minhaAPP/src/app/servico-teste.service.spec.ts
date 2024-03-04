import { TestBed } from '@angular/core/testing';

import { ServicoTesteService } from './servico-teste.service';

describe('ServicoTesteService', () => {
  let service: ServicoTesteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicoTesteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

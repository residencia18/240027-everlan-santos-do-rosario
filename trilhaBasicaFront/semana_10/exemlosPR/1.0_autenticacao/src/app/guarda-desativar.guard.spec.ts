import { TestBed } from '@angular/core/testing';
import { CanDeactivateFn } from '@angular/router';

import { guardaDesativarGuard } from './guarda-desativar.guard';

describe('guardaDesativarGuard', () => {
  const executeGuard: CanDeactivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => guardaDesativarGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});

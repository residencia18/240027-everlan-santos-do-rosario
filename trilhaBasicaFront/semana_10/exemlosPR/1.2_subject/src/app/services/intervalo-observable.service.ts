import { Injectable } from '@angular/core';
import { Observable, interval } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IntervaloObservableService {

  observavel = new Observable<number>();
  
  //interval(1000) cria um Observable que emite um número a cada segundo.
  //O método pipe é usado para transformar os números emitidos em números aleatórios usando
  // o operador map.
  constructor() {
    this.observavel = interval(1000).pipe(
      map(() => Math.random())
    );
   }
}

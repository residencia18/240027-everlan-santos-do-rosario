import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Obsevable0100Service {

  constructor() { }
   getNumbers(): Observable<any> {
     const numeros = from([1,2,3,4,5,6,7,8,9,10]);
     return numeros;
   }
}

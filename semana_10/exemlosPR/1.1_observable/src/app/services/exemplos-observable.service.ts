import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExemplosObservableService {

  constructor() { }

  getValores():Observable<any>{
    const observable = new Observable((subscriber) => {
      subscriber.next(1);
      subscriber.next(2);
      subscriber.next(3);
      setTimeout(() => {
        subscriber.next(4);
        subscriber.complete();
      }, 1000);
    });
    return observable;
  }

  
    //Este Observable emitirá cada valor do array, um de cada vez, 
    //na ordem em que aparecem no array.
    //O Observable emite o primeiro valor do array (1).
    //depois emite o segundo valor (2), e assim por diante.
    //O Observable completa.
    //Portanto, se você se inscrever neste Observable 
    //e registrar cada valor emitido, verá 1, 2, 3, 4, 5
    // registrado, nessa ordem.

    getNumeros():Observable<any>{
      const source = from([1, 2, 3, 4, 5]);
      return source;
    }


    getPaises():Promise<Pais[]> {
      let lista_paises: Pais[] = [];

      return fetch('https://restcountries.com/v3.1/all')
      .then((response) => response.json())
      .then((data) => {
        data.forEach((country: Pais) => {
          lista_paises.push(country);
        });
        return lista_paises;
      })              
      .catch(error => {
        console.error('There was an error!', error);
        return lista_paises;
      });
  }
}

interface Pais {
  name: {
    common: string;
  };
  population: number;
}

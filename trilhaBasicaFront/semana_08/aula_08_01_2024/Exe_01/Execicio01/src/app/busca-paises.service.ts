import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BuscaPaisesService {

  constructor(private http: HttpClient) { }

  getPaises() {
    return this.http.get('https://restcountries.com/v3.1/all');
  }
  
}

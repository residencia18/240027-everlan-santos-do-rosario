import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BuscaArtigosService {

  constructor(private http: HttpClient) { }

  urlbase = 'https://en.wikipedia.org/w/api.php';
  getArtigos(termo: any) {
    return this.http.get(this.urlbase, {
      params: {
        action: 'query',
        format: 'json',
        list: 'search',
        utf8: '1',
        origin: '*',
        srsearch: termo
      }
    });
  }
}

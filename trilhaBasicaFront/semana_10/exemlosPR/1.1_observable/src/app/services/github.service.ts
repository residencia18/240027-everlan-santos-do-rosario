import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GithubService {

  URLdePedido = 'https://api.github.com/users';

  constructor(private http: HttpClient) { }

  getUsuarios():Observable<any>{

    /*
    cria um array de URLs, e let pedidoStream = from(urls); 
    cria um Observable que emite cada URL do array uma após a outra.
    let urls = ['https://api.github.com/users', 'https://api.github.com/repos', 'https://api.github.com/events'];
    let pedidoStream = from(urls); */

    //cria um Observable que emite a string 'https://api.github.com/users' uma vez e depois a completa.
    let pedidoStream = of(this.URLdePedido);

    //this.http.get(url) returns an Observable of the HTTP response,
    //This asynchronous method sends an HTTP request, 
    //and returns an Observable 
    //that emits the requested data when the response is received.

    let responseStream = pedidoStream.pipe(
        switchMap(url => this.http.get(url))
    );
    //retorna um Observable que emite o resultado de fazer um pedido HTTP 
    //quando o Observable de origem emite.  

    /*
    ##Exemplo de uso de vários operadores de pipe:
    let responseStream = pedidoStream.pipe(
      switchMap(url => this.http.get(url)),
      map(res => res.json()),
      filter(res => res.total_count !== undefined),
      map(res => res.items)
    );

    ##OUTRO
     let responseStream = pedidoStream.pipe(
    debounceTime(300),
    switchMap(url => this.http.get(url)),
    map(response => response.data),
    filter(user => user.isActive),
    take(5),
    catchError(error => {
      console.error('Ocorreu um erro', error);
      return throwError(error);
    })
  );
    */
    return responseStream;
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AutenticaService } from './autentica.service';
import { Usuario } from '../model/usuario/usuario.module';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataBasenService {
  
  apiURL = 'https://suinocultura-f61b1-default-rtdb.firebaseio.com/'

  constructor(private http: HttpClient, private autenticacaoService: AutenticaService) { }

  addUser(user: {
    email: string,
    password: string
  }) {
    return this.http.post(this.apiURL,user).subscribe(
      (response) => {
        console.log(response);
      }
    )
  }

  getUser(){
    return this.http.get<{[key:string]: Usuario}>('https://suinocultura-f61b1-default-rtdb.firebaseio.com/user.json').pipe(
      map( (responseData) => {
        const listaArray:Usuario[] = [];
        for (const key in responseData) {
            if ((responseData).hasOwnProperty(key)){
              listaArray.push({...(responseData as any)[key], id: key});
            }
        }
        return listaArray;
      })
    )
  }
}

import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AutenticacaoService {

  private autenticacaoUsuarioSubject = new Subject<boolean>();

  //O $ após uma variável é uma convenção de nomenclatura
  // comum em programação reativa e Angular 
  //quando se trabalha com Observables

  usuarioAutenticado$ = this.autenticacaoUsuarioSubject.asObservable();

  constructor() { }

  autenticarUsuario(estaAutenticado: boolean) {
    this.autenticacaoUsuarioSubject.next(estaAutenticado);
  }
}

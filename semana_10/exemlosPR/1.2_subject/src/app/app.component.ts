import { Component } from '@angular/core';
import { AutenticacaoService } from './services/autenticacao.service';
import { IntervaloObservableService } from './services/intervalo-observable.service';
import { Subscription } from 'rxjs';
import { IntervaloSubjectService } from './services/intervalo-subject.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '1.2_subject';
  autenticado = false;
  numero = 0;
  inscricao: Subscription | undefined;

  constructor(private autenticaService: AutenticacaoService, private intervaloService: IntervaloSubjectService) {
    this.autenticaService.usuarioAutenticado$.subscribe(estaAutenticado => {
      console.log('usuarioAutenticado:', estaAutenticado);
      this.autenticado = estaAutenticado;
    });
  }

  autenticar() {
    this.autenticaService.autenticarUsuario(true);
  }

  desautenticar() {
    this.autenticaService.autenticarUsuario(false);
  }

  iniciarContador(){
    this.inscricao = this.intervaloService.subject.subscribe(numero => {
      this.numero = numero;
    });
  }

  pararContador(){
    this.inscricao?.unsubscribe();
  }
}

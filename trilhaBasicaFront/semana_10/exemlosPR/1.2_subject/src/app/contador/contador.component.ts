import { Component } from '@angular/core';
import { IntervaloObservableService } from '../services/intervalo-observable.service';
import { Subscription } from 'rxjs';
import { IntervaloSubjectService } from '../services/intervalo-subject.service';

@Component({
  selector: 'app-contador',
  templateUrl: './contador.component.html',
  styleUrls: ['./contador.component.css']
})
export class ContadorComponent {
  inscricao:Subscription | undefined;
  numero:number = 0;

  constructor(private intervaloService: IntervaloSubjectService) {
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

 



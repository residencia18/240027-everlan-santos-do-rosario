import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { IntervaloObservableService } from '../services/intervalo-observable.service';
import { IntervaloSubjectService } from '../services/intervalo-subject.service';

@Component({
  selector: 'app-contador2',
  templateUrl: './contador2.component.html',
  styleUrls: ['./contador2.component.css']
})
export class Contador2Component {
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

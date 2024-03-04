import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { IntervaloObservableService } from '../services/intervalo-observable.service';

@Component({
  selector: 'app-contador-obs3',
  templateUrl: './contador-obs3.component.html',
  styleUrls: ['./contador-obs3.component.css']
})
export class ContadorObs3Component {
  inscricao:Subscription | undefined;
  numero:number = 0;

  constructor(private intervaloService: IntervaloObservableService) {
  }
  
  iniciarContador(){
    this.inscricao = this.intervaloService.observavel.subscribe(numero => {
      this.numero = numero;
    });
  }

  pararContador(){
    this.inscricao?.unsubscribe();
  }
}

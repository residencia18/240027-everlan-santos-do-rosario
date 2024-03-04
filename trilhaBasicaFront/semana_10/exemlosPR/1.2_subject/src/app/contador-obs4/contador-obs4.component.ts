import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { IntervaloObservableService } from '../services/intervalo-observable.service';

@Component({
  selector: 'app-contador-obs4',
  templateUrl: './contador-obs4.component.html',
  styleUrls: ['./contador-obs4.component.css']
})
export class ContadorObs4Component {
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

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ClassesComponent } from './classes/classes.component';
import jsonData from '../assets/veiculo.json';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ClassesComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'JReader';

  objects: any = JSON.parse(JSON.stringify(jsonData));


  constructor() {
  }

  TiposVeiculos(){
    let Tipos: any = [];
    for(const obj of this.objects){
        Tipos.push(typeof obj)
    }
    return Tipos
  }
  
}

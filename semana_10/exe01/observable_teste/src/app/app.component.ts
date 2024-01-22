import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { Obsevable0100Service } from './obsevable-0-100.service';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    FormsModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'observable_teste';
  numeros: any[] = [];
  constructor(private obsevable0100Service: Obsevable0100Service) {}

  getNumbers(){
    const numeros = this.obsevable0100Service.getNumbers().subscribe(
      (numeros) => this.numeros.push(numeros)
    );
  }
    
  
}

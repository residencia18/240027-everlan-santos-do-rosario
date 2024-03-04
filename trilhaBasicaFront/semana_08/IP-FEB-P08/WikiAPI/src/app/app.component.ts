import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { BuscaArtigosService } from './busca-artigos.service';
import { FormsModule } from '@angular/forms';
import { query } from 'express';

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
  title = 'WikiAPI';
  termos: any;
  resultados: any = [];

  constructor(private busca: BuscaArtigosService) {}

  buscar() {
    this.busca.getArtigos(this.termos).pipe().subscribe(
      (res: any) => {
        this.resultados = res.query.search;
        console.log(res.query.search);
      }
    );
  }
}

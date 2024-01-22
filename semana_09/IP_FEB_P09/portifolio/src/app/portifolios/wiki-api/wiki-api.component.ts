import { Component } from '@angular/core';
import { BuscaArtigosService } from './busca-artigos.service';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-wiki-api',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    FormsModule
  ],
  templateUrl: './wiki-api.component.html',
  styleUrl: './wiki-api.component.css'
})
export class WikiAPIComponent {
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

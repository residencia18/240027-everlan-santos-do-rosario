import { Component, OnInit } from '@angular/core';
import { BuscaPaisesService } from '../busca-paises.service';

@Component({
  selector: 'app-lista-paises',
  standalone: true,
  imports: [BuscaPaisesService],
  templateUrl: './lista-paises.component.html',
  styleUrl: './lista-paises.component.css'
})
export class ListaPaisesComponent implements OnInit {
  buscaPaises: BuscaPaisesService[] = [];
  
  constructor(private buscaPaisesService: BuscaPaisesService) { }

  ngOnInit(): void {
    this.buscaPaisesService.getPaises().subscribe( (data) => {
      this.buscaPaises = data;
    });
  }
}

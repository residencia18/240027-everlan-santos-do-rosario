import { Component, OnInit } from '@angular/core';
import { GithubService } from '../services/github.service';
import { ExemplosObservableService } from '../services/exemplos-observable.service';
import { debounceTime, filter, map, mergeMap, of, scan } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuarios: any;
  valores:any[] = [];
  valores2:any[] = [];
  somaDeValores: number = 0;
  numeros:number = 10;
  paisPopulacao: {pais: string, populacao: number}[] = [];

  constructor(private githubService: GithubService, private valService: ExemplosObservableService) { }
  
  ngOnInit(): void {
    this.githubService.getUsuarios().subscribe(data => {
      this.usuarios = data;
    });
  }

  getValores2(){
    this.valService.getValores().pipe(
      scan((acc: number[], val: number) => [...acc, val], [])
    ).subscribe(arrayDeValores => {
      this.valores2 = arrayDeValores;
    });
  }

  getValores(){
    this.valService.getValores().subscribe(valor => {
      this.valores.push(valor);
    })
  }

  getSomadeValores(){
    this.valService.getValores().pipe(
      scan((acc: number, val: number) => acc + val, 0)
    ).subscribe(somaDeValores => {
      this.somaDeValores = somaDeValores;
    });
  }

  getNumeros(){
    //retorna um Observable
    const fonte = this.valService.getNumeros();
    //adiciona 100 a cada número
    const exemplo = fonte.pipe(
      map(val => val + 100),
      filter(n => n % 2 === 0),
      mergeMap(val => of(`${val} alterado!`)),
    );
    const inscricao = exemplo.subscribe(
      numero => {
        console.log(numero);
      }
    );
    // 101, 102, 103, 104, 105
  }

  getPaises(){
    this.valService.getPaises().then((data: Pais[]) => {
      data.forEach((country: Pais) => {
        console.log(`pais: ${country.name.common}, populacao: ${country.population}`);
        this.paisPopulacao.push({pais: country.name.common, populacao: country.population});
      });
    }
    )
  }




}

interface Pais {
  name: {
    common: string;
  };
  population: number;
}

import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit, OnDestroy {
  animal: {id: number} = {  id: 0 };
  inscricaoParametro: Subscription | undefined;
  ordem: string = '';
  inputText: string = '';
  

  animal2: {id: number, nome: string, proprietario: string, pai:number, mae: number} = {
    id: 0,
    nome: '',
    proprietario: '',
    pai: 0,
    mae: 0
  };
  
  constructor(private rota: ActivatedRoute) { }

  ngOnInit() {
    this.inscricaoParametro = this.rota.paramMap.subscribe(params => {
      this.animal.id = Number(params.get('id'));
    });

    this.rota.queryParams.subscribe( queryParams => {
        console.log(queryParams);
        this.ordem = queryParams['order'];
        console.log(this.ordem);
    });

        
  

   
  }

      // this.animal = {
    //   id: this.rota.snapshot.params['id'],
    // }
    
    //console.log(this.rota.snapshot.queryParams);

    ngOnDestroy() {
      this.inscricaoParametro?.unsubscribe();
    }

    onInputChange(event: Event) {
      const inputElement = event.target as HTMLInputElement;
      this.inputText = inputElement.value;
      console.log(this.inputText);
    }
}

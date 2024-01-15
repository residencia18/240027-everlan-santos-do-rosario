import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-animal-editar',
  templateUrl: './animal-editar.component.html',
  styleUrls: ['./animal-editar.component.css']
})
export class AnimalEditarComponent {
  inscricaoParametro: Subscription | undefined;
  animal: {id: number} = {  id: 0 };
  ordem: string = '';

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
    
}

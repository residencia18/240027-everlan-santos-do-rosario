import { Component, OnDestroy, OnInit } from '@angular/core';
import { TarefaService } from '../services/tarefa.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-lista-tarefas',
  templateUrl: './lista-tarefas.component.html',
  styleUrls: ['./lista-tarefas.component.css']
})
export class ListaTarefasComponent implements OnDestroy {
  tarefas: string[] = []; 

  inscricao:Subscription | undefined;

  constructor(private tarefaServico:TarefaService) { 
    this.inscricao = this.tarefaServico.tarefaSubject.subscribe(tarefas => {
      this.tarefas = tarefas;
    });
  } 

  ngOnDestroy(): void {
    this.inscricao?.unsubscribe();
  }

}

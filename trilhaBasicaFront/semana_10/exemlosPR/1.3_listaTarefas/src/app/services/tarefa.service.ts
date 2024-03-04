import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {
  private tarefas: string[] = [];

  tarefaSubject = new Subject<string[]>();
  constructor() { }

  adicionarTarefa(tarefa: string) {
    this.tarefas.push(tarefa);
    this.tarefaSubject.next(this.tarefas);
  }

  getTarefas() {
    //cópia do array, então as alterações feitas na cópia não 
    //afetarão o array original.
    return [...this.tarefas];
  }
}

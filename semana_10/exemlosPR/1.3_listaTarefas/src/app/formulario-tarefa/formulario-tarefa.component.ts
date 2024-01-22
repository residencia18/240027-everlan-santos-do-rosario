import { Component } from '@angular/core';
import { TarefaService } from '../services/tarefa.service';

@Component({
  selector: 'app-formulario-tarefa',
  templateUrl: './formulario-tarefa.component.html',
  styleUrls: ['./formulario-tarefa.component.css']
})
export class FormularioTarefaComponent {
  novaTarefa: string = '';

  constructor(private tarefaServico:TarefaService) { 
    
  }

  adicionarTarefa() {
    this.tarefaServico.adicionarTarefa(this.novaTarefa);
    this.novaTarefa = '';
  }

}

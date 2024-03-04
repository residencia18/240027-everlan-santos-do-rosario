import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NegritoDirective } from '../negrito.directive';
import { EstruturaSomeDirective } from '../estrutura-some.directive';
import { PiscaDirective } from '../pisca.directive';

@Component({
  selector: 'app-arara',
  standalone: true,
  imports: [FormsModule, NegritoDirective, EstruturaSomeDirective, PiscaDirective],
  templateUrl: './arara.component.html',
  styleUrl: './arara.component.css'
})
export class AraraComponent {
  nome: string = 'Arara Azul';
  imagem: string = 'https://s1.static.brasilescola.uol.com.br/be/conteudo/images/arara-azul.jpg';
  descricao: string = 'Arara azul e um mamiúlo de raposa';
  cor: string = 'blue';
  permissao: string = '';
  @Input() corInput: string = '';
  Digitandocor(event: any){
    this.cor = event.target.value;
    if(this.cor === 'blue'){
      this.alterarCor();
    }else{
      this.alterarCor();
    }
  }
  alterarCor(){
    if(this.cor === 'blue'){
      this.cor = 'red';
    }else{
      this.cor = 'blue';
    }
  }
}



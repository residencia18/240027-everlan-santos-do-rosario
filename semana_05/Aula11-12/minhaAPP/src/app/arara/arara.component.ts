import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-arara',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './arara.component.html',
  styleUrl: './arara.component.css'
})
export class AraraComponent {
  nome: string = 'Arara Azul';
  imagem: string = 'https://s1.static.brasilescola.uol.com.br/be/conteudo/images/arara-azul.jpg';
  descricao: string = 'Arara azul e um mamiúlo de raposa';
  cor: string = 'blue';
}



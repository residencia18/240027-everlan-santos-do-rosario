import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { TabelaComponent } from './tabela/tabela.component';
import { AraraComponent } from './arara/arara.component';
import { NegritoDirective } from './negrito.directive';
import { EstruturaSomeDirective } from './estrutura-some.directive';
import { DemoPipePipe } from './demo-pipe.pipe';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    TabelaComponent,
    AraraComponent,
    NegritoDirective,
    EstruturaSomeDirective,
    DemoPipePipe
  ],
  //template: '<app-arara></app-arara><app-tabela></app-tabela>',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'minhaAPP';
}

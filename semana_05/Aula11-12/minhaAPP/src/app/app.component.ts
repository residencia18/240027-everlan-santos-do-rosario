import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { TabelaComponent } from './tabela/tabela.component';
import { AraraComponent } from './arara/arara.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, TabelaComponent, AraraComponent],
  //template: '<app-arara></app-arara><app-tabela></app-tabela>',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'minhaAPP';
}

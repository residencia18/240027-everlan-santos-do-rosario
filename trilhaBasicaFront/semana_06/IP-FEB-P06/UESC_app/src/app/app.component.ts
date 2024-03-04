import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { DestaqueComponent } from './destaque/destaque.component';
import { NoticiasComponent } from './noticias/noticias.component';
import { ServicosComponent } from './servicos/servicos.component';
import { ResultadosComponent } from './resultados/resultados.component';
import { MenusComponent } from './menus/menus.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    DestaqueComponent,
    NoticiasComponent,
    ServicosComponent,
    ResultadosComponent,
    MenusComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'UESC_app';
}

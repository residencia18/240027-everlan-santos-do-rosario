import { Routes } from '@angular/router';
import { HomeComponent } from './componentes/home/home.component';
import { AtendimentoComponent } from './componentes/atendimento/atendimento.component';
import { ContatoComponent } from './componentes/contato/contato.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'atendimento', component: AtendimentoComponent },
    { path: 'contato', component: ContatoComponent }
];

import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SobreComponent } from './sobre/sobre.component';
import { ContatoComponent } from './contato/contato.component';



export const routes: Routes = [
    { path: 'Home', component: HomeComponent },
    { path: 'Sobre', component: SobreComponent },
    { path: 'Contato', component: ContatoComponent },
];

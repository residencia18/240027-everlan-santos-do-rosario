import { Routes} from '@angular/router';
import { Conponente1Component } from './componentes/conponente1/conponente1.component';
import { Conponente2Component } from './componentes/conponente2/conponente2.component';
import { AppComponent } from './app.component';


export const routes: Routes = [
    { path: '', redirectTo: 'component1', pathMatch: 'full' },
    { path: 'component1', component: Conponente1Component },
    { path: 'component2', component: Conponente2Component }
];

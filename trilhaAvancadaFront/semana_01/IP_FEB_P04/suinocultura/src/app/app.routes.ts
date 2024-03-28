import { Routes } from '@angular/router';
import { CadastroSuinoComponent } from './componentes/cadastro-suino/cadastro-suino.component';
import { authGuard } from './componentes/guard/auth.guard';
import { AppComponent } from './app.component';
import { CadUserComponent } from './componentes/cad-user/cad-user.component';
import { LoginComponent } from './componentes/login/login.component';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'cadastro', component: CadUserComponent },
    {
        path: '',
        component: AppComponent,
        canActivate: [authGuard]
    },
    {
        path: 'cadastrosuino',
        component: CadastroSuinoComponent,
        canActivate: [authGuard]
    },
    // { 
    //     path: 'listarsuino', 
    //     component: CadastroSuinoComponent,
    //     canActivate:[authGuard]
    // }
    { path: '**', redirectTo: 'login' },
];

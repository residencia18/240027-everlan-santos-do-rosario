import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { CadUserComponent } from './components/cad-user/cad-user.component';
import { HomeComponent } from './components/home/home.component';
import { CadastroSuinoComponent } from './components/cadastro-suino/cadastro-suino.component';
import { authGuard } from './guard/auth.guard';

export const routes: Routes = [
    
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'cadastro', component: CadUserComponent },
    { 
        path:'home',
        component: HomeComponent,
        children:[
            { path: 'cadastrosuino', component: CadastroSuinoComponent, canActivate:[authGuard] },
            { path: 'listarsuino', component: CadastroSuinoComponent, canActivate:[authGuard] }
        ],
        canActivate:[authGuard]
    },
    { 
        path: 'cadastrosuino',
        component: CadastroSuinoComponent,
        canActivate:[authGuard]
    },
    { 
        path: 'listarsuino', 
        component: CadastroSuinoComponent,
        canActivate:[authGuard]
    }
];

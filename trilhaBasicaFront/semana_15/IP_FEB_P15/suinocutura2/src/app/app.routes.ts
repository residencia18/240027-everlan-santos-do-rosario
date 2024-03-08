import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { CadUserComponent } from './components/cad-user/cad-user.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: '**', redirectTo: 'login' },
    { path: 'cadastro', component: CadUserComponent }
];

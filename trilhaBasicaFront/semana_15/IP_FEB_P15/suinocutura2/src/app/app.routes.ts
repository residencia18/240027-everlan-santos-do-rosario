import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { CadUserComponent } from './components/cad-user/cad-user.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'cadastro', component: CadUserComponent },
    { path: 'home', component: HomeComponent },
    { path: '**', redirectTo: 'login' },
];

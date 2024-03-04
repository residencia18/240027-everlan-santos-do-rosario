import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { Routes, RouterModule } from '@angular/router';
import { ToolBarComponent } from './tool-bar/tool-bar.component';
import { guardaGuard } from './guarda.guard';
import { HomeComponent } from './home/home.component';
import { AutenticacaoService } from './autenticacao.service';
import { FormsModule } from '@angular/forms';
import { guardaDesativarGuard } from './guarda-desativar.guard';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { EditUsuarioComponent } from './edit-usuario/edit-usuario.component';
import { canDesativarGuard } from './desativar.interface';


//canDeactivate:[guardaDesativarGuard]

const rotasApp: Routes = [
  { path: '', canActivate:[guardaGuard], component: AppComponent},
  { path: 'login',component: LoginComponent },
  {path: 'usuarios', canActivate:[guardaGuard], canDeactivate: [canDesativarGuard], component: UsuariosComponent, 
    children: [
          {path: ':id/edit', component: EditUsuarioComponent, canDeactivate: [canDesativarGuard]}
    ]
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ToolBarComponent,
    HomeComponent,
    UsuariosComponent,
    EditUsuarioComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    RouterModule.forRoot(rotasApp)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component} from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AngularFireAuthModule } from '@angular/fire/compat/auth';
import { AngularFireModule } from '@angular/fire/compat';
import { AuthService } from './service/auth.service';
import { environment } from '../environments/environment';
import { CadastroSuinoComponent } from './components/cadastro-suino/cadastro-suino.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    FormsModule,
    RouterLink,
    CadastroSuinoComponent,
    AngularFireAuthModule,
    AngularFireModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'suinocutura2';
  currentYear = new Date().getFullYear();

  constructor(public authService: AuthService, private rotas: Router) {
    // AngularFireModule.initializeApp(environment.firebaseConfig);
  }

  ngOnInit() {
    this.authService.user$.subscribe((user) => {
      if (user) {
        this.authService.currentUserSing.set(user);
      }else {
        this.authService.currentUserSing.set(null);
      }
    })
  }

  ngOnDestroy() {
    this.authService.logout();
  }
}

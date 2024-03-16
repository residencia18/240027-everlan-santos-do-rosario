import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterModule, RouterOutlet } from '@angular/router';
import { AuthService } from './service/auth.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterLink,
    RouterModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'suinocultura';
  currentYear = new Date().getFullYear();
  username: string | null = '';
  constructor(public authService: AuthService) {
  }

  islogin() {
    if (this.authService.auth.currentUser) {
      this.username = this.authService.user?.email;
      return true;
    }else{
      this.username = '';
      return false;
    }
  }
  logout() {
    this.authService.logout();
  }
  
}

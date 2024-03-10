import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  
  constructor(public authService: AuthService, private rotas: Router) {
    
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
  

}


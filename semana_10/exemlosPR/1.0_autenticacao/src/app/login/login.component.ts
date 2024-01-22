import { Component } from '@angular/core';
import { AutenticacaoService } from '../autenticacao.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private autenticacaoService: AutenticacaoService, private router: Router) {}
  reset() {
    this.username = '';
    this.password = '';
  }

  login() {
    this.autenticacaoService.autenticar(this.username, this.password);
    if (this.autenticacaoService.isAutenticado()) {
        this.router.navigate(['/']);
      } else {
        alert('Usuário ou senha inválidos!')
        this.reset();
      }
  }
}

import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormsModule, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-cad-user',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './cad-user.component.html',
  styleUrl: './cad-user.component.css'
})
export class CadUserComponent {
  currentYear = new Date().getFullYear();
  loginForm: FormGroup;
  googleRegexemail: RegExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  erro: boolean = false;
  msgErro: string = '';

  constructor(public authService: AuthService, private rotas: Router) {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern(this.googleRegexemail)]),
      password: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)]),
      password2: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)]),
    })
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

  equalPassword(frm: FormGroup): { [key: string]: boolean } | null {
    const password = frm.get('password')?.value;
    const password2 = frm.get('password2')?.value;
    console.log(password, password2)
    if (password === password2) {
      return { 'equalPassword': true };
    }
    return null;
  }

  onReset() {
    this.loginForm.reset();
  }

  onSubmit() {
    if (this.loginForm.valid) {
      if(this.equalPassword(this.loginForm)?.['equalPassword'] === true){
        this.erro = false;
        this.msgErro = '';
        this.onSingUp();
      }else{
        this.erro = true;
        this.msgErro = 'As senhas precisam ser iguais';
      }
    }
  }

  async onSingUp() {
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
      const result = await (this.authService.signUp(email, password));
      if(!this.authService.error){
        this.onReset();
        this.rotas.navigate(['login']);
        this.authService.logout();
        this.erro = false;
        this.msgErro = '';
      }else{
        this.erro = true;
        this.msgErro = this.authService.error;
      }
    } else {
      this.onReset();
      this.erro = true;
      this.msgErro = 'Todos os campos precisam ser preenchidos';
    }
  }
  
}


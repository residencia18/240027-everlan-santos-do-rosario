import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormsModule, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cad-user',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    CommonModule
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

  constructor(private authService: AuthService, private rotas: Router) {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern(this.googleRegexemail)]),
      password: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)]),
      password2: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)]),
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
        this.onSingUp();
      }else{
        alert('As senhas devem ser iguais');
      }
    }
  }

  async onSingUp() {
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
      const result = await (this.authService.signUp(email, password));
      if(result.erro){
        this.onReset();
        this.rotas.navigate(['login']);
        this.erro = false;
      }else{
        this.erro = true;
        this.msgErro = result.message;
      }
    } else {
      this.onReset();
    }
  }
  
}


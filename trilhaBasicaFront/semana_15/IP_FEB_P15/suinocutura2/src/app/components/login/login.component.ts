import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  currentYear = new Date().getFullYear();
  loginForm: FormGroup;
  googleRegexemail: RegExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  constructor(private authService: AuthService) {
    
    this.loginForm = new FormGroup({
      email: new FormControl ('', [Validators.required, Validators.pattern(this.googleRegexemail)]),
      password: new FormControl ('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)])
    })
   }

   onReset() {
     this.loginForm.reset();
   }

  onSingIn() {
    console.log(this.loginForm.valid);//Remover
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
      this.authService.signIn(email, password);
    }else{
      this.onReset();
    }
  }
}

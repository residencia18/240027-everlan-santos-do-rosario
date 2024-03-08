import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormsModule, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';

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

  constructor(private authService: AuthService) {
    
    this.loginForm = new FormGroup({
      email: new FormControl ('', [Validators.required, Validators.pattern(this.googleRegexemail)]),
      password: new FormControl ('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)]),
      password2: new FormControl ('', [Validators.required, Validators.minLength(6), Validators.maxLength(13), this.equalPassword.bind(this)])
      
    })
   }

   equalPassword(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')?.value;
    const password2 = control.get('password2')?.value;
    if (password === password2) {
      return {equalPassword: true};
    } else {
      return null;
    }
   }

   onReset() {
     this.loginForm.reset();
   }

  onSingUp() {
    console.log(this.loginForm.value);//Remover
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
      this.authService.signUp(email, password);
    }else{
      this.onReset();
    }
  }
}

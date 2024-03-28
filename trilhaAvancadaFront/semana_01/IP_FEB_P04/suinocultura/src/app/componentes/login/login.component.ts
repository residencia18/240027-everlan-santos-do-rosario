import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { routes } from '../../app.routes';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    RouterLink,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  loginForm: FormGroup;
  googleRegexemail: RegExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  errormsg: string = '';
  constructor(public authService: AuthService, private router: Router) {
    
    this.loginForm = new FormGroup({
      email: new FormControl ('', [Validators.required, Validators.pattern(this.googleRegexemail)]),
      password: new FormControl ('', [Validators.required, Validators.minLength(6), Validators.maxLength(13)])
    })
   }

   OnInit() {
     this.authService.user$.subscribe((user) => {
       if (user) {
         this.authService.currentUserSing.set(user);
         this.onReset();
       }else {
         this.authService.auth.currentUser?.delete();
         this.authService.currentUserSing.set(null);
         this.onReset();
         this.authService.logout();
       }
     })
   }

   onReset() {
     this.loginForm.reset();
   }

   onSignIn() {
     this.authService.signIn(this.loginForm.get('email')?.value, this.loginForm.get('password')?.value).catch((err) => {
       this.errormsg = err.message;
       this.onReset();
     });
     
   }

  // onSingIn() {
  //   console.log(this.loginForm.valid);//Remover
  //   if (this.loginForm.valid) {
  //     const email = this.loginForm.get('email')?.value;
  //     const password = this.loginForm.get('password')?.value;
  //     if (this.authService.signIn(email, password) !== null) {
  //       this.rotas.navigate(['home']);
  //     }
  //   }else{
  //     this.onReset();
  //   }
  // }
}

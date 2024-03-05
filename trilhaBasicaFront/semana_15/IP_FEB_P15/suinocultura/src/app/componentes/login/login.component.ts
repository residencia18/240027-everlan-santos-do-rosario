import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatSlideToggleModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  currentYear = new Date().getFullYear();
  loginForm!: FormGroup;

  constructor(private formConstrutor: FormBuilder) {}

  ngOnInit() {
    this.loginForm = this.formConstrutor.group({
      userName: ['', Validators.required],
      userPassword: ['', Validators.required, Validators.minLength(4), Validators.maxLength(13)],
    })
  }

  onSubmit() {
    console.log(this.loginForm.value);
  }
}

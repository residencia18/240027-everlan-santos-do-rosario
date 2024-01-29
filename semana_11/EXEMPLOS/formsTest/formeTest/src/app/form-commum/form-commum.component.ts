import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';


@Component({
  selector: 'app-form-commum',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './form-commum.component.html',
  styleUrl: './form-commum.component.css'
})
export class FormCommumComponent {

  constructor() {
    
  }

  onSubmit(LoginForm: NgForm) {
    let { login, senha } = LoginForm.value
    console.log(login, senha);
  }
}

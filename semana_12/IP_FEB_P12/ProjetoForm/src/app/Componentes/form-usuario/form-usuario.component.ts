import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormsModule, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-usuario',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './form-usuario.component.html',
  styleUrl: './form-usuario.component.css'
})
export class FormUsuarioComponent {
  UsuarioForm: FormGroup;

  constructor() { 
    this.UsuarioForm = new FormGroup({
      id: new FormControl(null, Validators.required),
      nome: new FormControl(null, [
          Validators.required,
          Validators.maxLength(12),
          Validators.pattern('[a-zA-Z]*'),
        ]),
      senha: new FormControl(null, [
          Validators.required,
          Validators.pattern('^(?=.*[A-Z])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]+$'),
          Validators.minLength(4),
          Validators.maxLength(13)
        ]),
      email: new FormControl(null, [
        Validators.required,
        Validators.email,
        // Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
      ]),
      nome_completo: new FormControl(null, [
        Validators.required,
        Validators.pattern('^([A-Za-zÀ-ú]{2,40}(?: [A-Za-zÀ-ú]+){0,3}) ([A-Za-zÀ-ú]{2,40}(?: [A-Za-zÀ-ú]+){0,3})$'),
      ]),
      telefone: new FormControl(null, [
        Validators.required,
        Validators.pattern('([1-9]{2}) ([9]{1}) ([0-9]{4})-([0-9]{4})'),
      ]),
      data_nasc: new FormControl(null, [
        Validators.required,
        this.minimaIdade.bind(this),
      ])
    })
   }

  onSubmit(){
    console.log(this.UsuarioForm);
    console.log(this.UsuarioForm.value);
  }

  onReset(){
    this.UsuarioForm.reset();
  }

  minimaIdade(control: AbstractControl): ValidationErrors | null{
    const dataNasc = new Date(control.value);
    const atualAno = new Date();
    const idade = Math.floor((atualAno.getTime() - dataNasc.getTime()) / (1000 * 3600 * 24 * 365.25));

    if(idade < 18){
      return { 'minimaIdade': true };
    }
    return null;
  }
  
}

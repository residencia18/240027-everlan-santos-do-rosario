import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';


@Component({
  selector: 'app-form-usuario',
  standalone: true,
  imports: [
    ReactiveFormsModule
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
          Validators.maxLength(13),
          Validators.pattern('(?=.*[A-Z])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]'),
          Validators.minLength(4),
        ]),
      email: new FormControl(null, [
        Validators.required,
        Validators.email,
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
      ]),
      nome_completo: new FormControl(null, [
        Validators.required,
        Validators.pattern('([A-Za-záàâãéèêíóòôõúùûç]{2,})([ ]{1})([A-Za-záàâãéèêíóòôõúùûç]{2,})'),
      ]),
      telefone: new FormControl(null, [
        Validators.required,
        Validators.pattern('(\([1-9]{2}\))(\s)([9]{1})(\d{4})-(\d{4})'),
      ]),
      data_nasc: new FormControl(null, [
        Validators.required,
        this.minimaIdade.bind(this),
        Validators.pattern('(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}'),      ])
    })
   }

  onSubmit(){
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

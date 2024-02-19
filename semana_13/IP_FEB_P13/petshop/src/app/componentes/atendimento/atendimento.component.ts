import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-atendimento',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './atendimento.component.html',
  styleUrl: './atendimento.component.css'
})
export class AtendimentoComponent {
  atendimentoForm: FormGroup;

  constructor() {
    this.atendimentoForm = new FormGroup({
      nomepai: new FormControl(null, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(20),
        Validators.pattern('[a-zA-Z]*'),
      ]),
      telefone: new FormControl(null, [
        Validators.required,
        Validators.pattern('([1-9]{2}) ([9]{1}) ([0-9]{4})-([0-9]{4})'),
      ]),

      nomepet: new FormControl(null, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(20),
        Validators.pattern('[a-zA-Z]*'),
      ]),
      especie: new FormControl(null, [
        Validators.required,
      ]),

      idade: new FormControl(null, [
        Validators.required,
        Validators.pattern('[0-9]*'),
      ]),
      historico: new FormControl(null, [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(100),
      ])
    })
  }

  onSubmit() {
    console.log(this.atendimentoForm);
    console.log(this.atendimentoForm.value);
  }

  onReset() {
    this.atendimentoForm.reset();
  }
}

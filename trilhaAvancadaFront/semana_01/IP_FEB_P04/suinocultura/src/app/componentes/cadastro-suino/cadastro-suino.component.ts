import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
import { suinoModel } from '../../model/suino.model';
import { SuinoService } from '../../service/suino.service';


@Component({
  selector: 'app-cadastro-suino',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
  ],
  templateUrl: './cadastro-suino.component.html',
  styleUrl: './cadastro-suino.component.css'
})
export class CadastroSuinoComponent {
  formSuino: FormGroup;
  error: any;

  constructor(private router: Router, private fb: FormBuilder, private ss: SuinoService) {
    this.formSuino = this.fb.group({
      brincoAnimal: ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      brincoPai: ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      brincoMae: ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      dataNascimento: ['', Validators.required],
      dataSaida: ['', Validators.required],
      status: ['', Validators.required],
      sexo: ['', Validators.required]
    });
  }
  // , this.brincoMaeValidoValidator.bind(this), this.sexoMaeValidoValidator.bind(this)]

  onReset() {
    this.formSuino.reset();
  }
  brincoMaeValidoValidator(control: any) {
    const brincoMae: any = this.ss.getSuino(control.value);
    if (brincoMae) {
      return { brincoMae: true };
    }else {
      return null;
    }
  }

  sexoMaeValidoValidator(control: any) {
    const Mae: any = this.ss.getSuino(control.value);
    if (Mae.sexo == 'Femea') {
      return { sexoMae: true };
    }else {
      return null;
    }
  }

  sexoPaiValidoValidator(control: any) {
    const Pai: any = this.ss.getSuino(control.value);
    if (Pai.sexo == 'Macho') {
      return { sexoPai: true };
    }else {
      return null;
    }
  }

  onSubmit() {
    if (this.formSuino.valid) {
      const suino: suinoModel = this.formSuino.value;
      this.ss.createSuino(suino);
      if (this.ss.error) {
        this.error = this.ss.error;
        this.onReset();
        this.router.navigate(['/cadastrosuino']);
      }else {
        this.error = null;
        this.onReset();
        this.router.navigate(['/cadastrosuino']);
      }
    }
  }
}

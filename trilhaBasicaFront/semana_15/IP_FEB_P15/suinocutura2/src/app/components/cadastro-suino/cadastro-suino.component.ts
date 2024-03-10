import { Component } from '@angular/core';
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

  constructor(public authService: AuthService, private ss: SuinoService, private router: Router, private fb: FormBuilder) {
    this.formSuino = this.fb.group({
      brincoAnimal: ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      brincoPai: ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      brincoMae: ['', [Validators.required, Validators.pattern(/^[0-9]+$/)], this.brincoMaeValidoValidator.bind(this), this.sexoMaeValidoValidator.bind(this)],
      dataNascimento: ['', Validators.required],
      dataSaida: ['', Validators.required],
      status: ['', Validators.required],
      sexo: ['', Validators.required]
    });
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
    if (Mae.sexo == 'F') {
      return { sexoMae: true };
    }else {
      return null;
    }
  }

  ngOnInit() {
    this.authService.user$.subscribe((user) => {
      if (user) {
        this.authService.currentUserSing.set(user);
      }else {
        this.authService.currentUserSing.set(null);
      }
    })
  }

  onSubmit() {
    if (this.formSuino.valid && this.authService.user) {
      const suino: suinoModel = this.formSuino.value;
      this.ss.createSuino(suino);
      if (this.ss.error) {
        this.error = this.ss.error;
      }else {
        this.error = null;
        this.router.navigate(['/suinos']);
      }
    }
  }
}

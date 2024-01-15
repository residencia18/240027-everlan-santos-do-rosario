import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-classes',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './classes.component.html',
  styleUrl: './classes.component.css'
})
export class ClassesComponent {
  @Input() veiculos: any = [];
  @Input() Tipos: any = [];

  constructor() { }


  ngOnInit(): void {
    console.log(this.Tipos[0])
  }

}

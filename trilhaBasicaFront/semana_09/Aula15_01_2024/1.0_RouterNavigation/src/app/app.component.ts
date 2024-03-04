import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '1.0_RouterNavigation';
  rota: string = '';
  inputText: string = '';
  constructor(private rotas:Router, private rotaAtiva: ActivatedRoute){
    
  }

  paraAviao(){
    this.rotas.navigate(['aviao']);
  }

  paraAnimal() {
    this.rotas.navigate(['animal', this.inputText]);
  }

  
  paraAnimalPesados() {
    this.rotas.navigate(
      ['animal'],
      {queryParams: {order: 'pesados', vacinados: 'true'}}
    );
  }

  onInputChange(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    this.inputText = inputElement.value;
    console.log(this.inputText);
  }
}

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AviaoComponent } from './aviao/aviao.component';
import { CarroComponent } from './carro/carro.component';
import { BarcoComponent } from './barco/barco.component';
import { Router, RouterModule, Routes } from '@angular/router';
import { AnimalComponent } from './animal/animal.component';
import { FormsModule } from '@angular/forms';
import { AnimalEditarComponent } from './animal-editar/animal-editar.component';

const rotasApp: Routes = [
  { path: 'aviao', component: AviaoComponent },
  { path: 'carro', component: CarroComponent },
  { path: 'barco', component: BarcoComponent },
  
  { path: 'animal', component: AnimalComponent, children: [
    { path: ':id', component: AnimalComponent },
    { path: ':id/editar', component: AnimalEditarComponent }
  ]},
];

@NgModule({
  declarations: [
    AppComponent,
    AviaoComponent,
    CarroComponent,
    BarcoComponent,
    AnimalComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
     //registrar as rotas no Angular 
     RouterModule.forRoot(rotasApp)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

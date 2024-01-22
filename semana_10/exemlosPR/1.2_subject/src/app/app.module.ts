import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ContadorComponent } from './contador/contador.component';
import { Contador2Component } from './contador2/contador2.component';
import { ContadorObs3Component } from './contador-obs3/contador-obs3.component';
import { ContadorObs4Component } from './contador-obs4/contador-obs4.component';

@NgModule({
  declarations: [
    AppComponent,
    ContadorComponent,
    Contador2Component,
    ContadorObs3Component,
    ContadorObs4Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

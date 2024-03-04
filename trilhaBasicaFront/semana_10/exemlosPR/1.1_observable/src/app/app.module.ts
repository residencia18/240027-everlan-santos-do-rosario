import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import {HomeComponent} from './home/home.component';	

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule // import HttpClientModule after BrowserModule.
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getAuth, provideAuth } from '@angular/fire/auth';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(), importProvidersFrom(provideFirebaseApp(() => initializeApp({"projectId":"suinocultura-f61b1","appId":"1:738147434091:web:ccb9559bd457e2297afb2e","databaseURL":"https://suinocultura-f61b1-default-rtdb.firebaseio.com","storageBucket":"suinocultura-f61b1.appspot.com","apiKey":"AIzaSyBifslR6SJqRZIe5XqdnST3IF5HRbQckQU","authDomain":"suinocultura-f61b1.firebaseapp.com","messagingSenderId":"738147434091","measurementId":"G-QEWY0H536P"}))), importProvidersFrom(provideAuth(() => getAuth()))]
};

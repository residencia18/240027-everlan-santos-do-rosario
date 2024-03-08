import { Injectable } from '@angular/core';
import { Auth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from '@angular/fire/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private auth: Auth) { }

	signIn = async (email: string, password: string) => {
		try {
      const result = await signInWithEmailAndPassword(this.auth, email, password);
      console.log(result);
		}catch (err) {
			console.log(err);
		}
	}

	signUp = async (email: string, password: string) => {
		try {
			const result = await createUserWithEmailAndPassword(this.auth, email, password);
      console.log(result);
		}catch (err) {
      console.log(err);
		}
	}
}

import { Injectable, inject, signal } from '@angular/core';
import { Auth, signInWithEmailAndPassword, createUserWithEmailAndPassword, user } from '@angular/fire/auth';
// import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';
// import { Observable } from 'rxjs';


@Injectable({
	providedIn: 'root'
})
export class AuthService {
	auth = inject(Auth);
	user$ = user(this.auth);
	user: any;
	error: any;
	currentUserSing = signal<any | null | undefined>(undefined);

	// constructor(private auth: AngularFireAuth) { }

	// get userOb(): Observable<any | null> {
	// 	return this.auth.user;
	// }

	// isAuthenticated(): boolean {
	// 	return this.auth.currentUser != null;
	// }

	// signIn(email: string, password: string): Promise<any> {
	// 	return this.auth.signInWithEmailAndPassword(email, password)
	// 		.then(() => this.user = this.auth.currentUser)
	// 		.catch((error) => {
	// 			switch (error.code) {
	// 				case "auth/user-not-found":
	// 					this.error = "Usuário não encontrado";
	// 					break;
	// 				case "auth/invalid-credential":
	// 					this.error = "Credenciais inválidas";
	// 					break;
	// 				case "auth/wrong-password":
	// 					this.error = "Email ou Senha incorreta";
	// 					break;
	// 				default:
	// 					this.error = "Erro na autenticação";
	// 			}
	// 		})
	// }

	// logout(): Promise<void> {
	// 	return this.auth.signOut();
	// }

	// signUp(email: string, password: string): Promise<any> {
	// 	return this.auth.createUserWithEmailAndPassword(email, password)
	// 		.catch((error) => {
	// 			switch (error.code) {
	// 				case "auth/email-already-in-use":
	// 					this.error = "Email já existe";
	// 					break;
	// 				case "auth/invalid-email":
	// 					this.error = "Email inválido";
	// 					break;
	// 				case "auth/weak-password":
	// 					this.error = "Senha fraca";
	// 					break;
	// 				case "auth/wrong-password":
	// 					this.error = "Email ou Senha incorreta";
	// 					break;
	// 				default:
	// 					this.error = "Erro ao registrar";
	// 			}
	// 		})
	// }

	constructor(private router: Router) { }

	signIn = async (email: string, password: string) => {
		try {
			const result = await signInWithEmailAndPassword(this.auth, email, password);
			this.user = result.user;
			this.router.navigate(['/home']);
		} catch (error: any) {
			switch (error.code) {
				case "auth/user-not-found":
					this.error = "Usuário não encontrado";
					break;
				case "auth/invalid-credential":
					this.error = "Credenciais inválidas";
					break;
				case "auth/wrong-password":
					this.error = "Email ou Senha incorreta";
					break;
				default:
					this.error = "Erro na autenticação";
			}
		}
	}

	logout = async () => {
		await this.auth.signOut();
		this.user = null;
		this.router.navigate(['/login']);
	}

	signUp = async (email: string, password: string) => {
		try {
			const result = await createUserWithEmailAndPassword(this.auth, email, password);
			this.user = result.user;
			this.router.navigate(['/login']);
		}
		catch (error: any) {
			switch (error.code) {
				case "auth/email-already-in-use":
					this.error = "Email já existe";
					break;
				case "auth/invalid-email":
					this.error = "Email inválido";
					break;
				case "auth/weak-password":
					this.error = "Senha fraca";
					break;
				case "auth/wrong-password":
					this.error = "Email ou Senha incorreta";
					break;
				default:
					this.error = "Erro ao registrar";
			}

		}
	}
}

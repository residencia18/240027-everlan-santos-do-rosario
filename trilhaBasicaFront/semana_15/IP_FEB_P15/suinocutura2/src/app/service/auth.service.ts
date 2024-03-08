import { Injectable } from '@angular/core';
import { Auth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from '@angular/fire/auth';
import { error } from 'console';

@Injectable({
	providedIn: 'root'
})
export class AuthService {

	constructor(private auth: Auth) { }

	signIn = async (email: string, password: string) => {
		try {
			const result = await signInWithEmailAndPassword(this.auth, email, password);
			return result;
		} catch (error: any) {			
			return null;
		}
	}

	signUp = async (email: string, password: string) => {
		try {
			const result = await createUserWithEmailAndPassword(this.auth, email, password);
			const retorno ={
				erro: false,
				result: result,
				code: null,
				message: null
			}
			return retorno;
		} catch (err: any) {
			const erro = {
				message: err.message,
				code: err.code,
				erro: true
			}
			if (erro.code === 'auth/email-already-in-use') {
				erro.message = 'Email ja existe';
			}else if (erro.code === 'auth/invalid-email') {
				erro.message = 'Email invalido';
			}else if (erro.code === 'auth/weak-password') {
				erro.message = 'A senha deve conter pelo menos 6 caracteres';
			}else if (erro.code === 'auth/operation-not-allowed') {
				erro.message = 'Operacao nao permitida';
			}else{
				erro.message = 'Erro ao registrar';
			}
			return erro;
		}
	}
}

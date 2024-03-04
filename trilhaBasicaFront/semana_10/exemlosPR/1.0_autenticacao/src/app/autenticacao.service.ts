import { Injectable } from "@angular/core";
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root',
})

export class AutenticacaoService {

    private usuarioAutenticado: boolean = false;

    constructor(private router: Router) { }

    public isAutenticado(): boolean {
        return this.usuarioAutenticado;
    }

    public autenticar(usuario: string, senha: string): void {
        if (usuario === '1' && senha === '1') {
            this.usuarioAutenticado = true;
        } else {
            this.usuarioAutenticado = false;
        }
    }

    public logout(): void {
        this.usuarioAutenticado = false;
        this.router.navigate(['/login']);
    }
}
import { CanDeactivateFn, Router } from '@angular/router';
import { AutenticacaoService } from './autenticacao.service';
import { inject } from '@angular/core';

export const guardaDesativarGuard: CanDeactivateFn<unknown> = (
  component,
  currentRoute, 
  currentState, 
  nextState) => {

  // const servicoAutenticacao = inject(AutenticacaoService);
  // const router = inject(Router);
  // if(servicoAutenticacao.isAutenticado()) {
  //   console.log('autenticado');
  //   const escolhaDoUsuario = confirm('Deseja sair da pagina?');
  //   if(escolhaDoUsuario){
  //     console.log('autenticado em garda-desativar.guard.ts');
  //     return true;
  //   }else {
  //     console.log('false em garda-desativar.guard.ts');
  //     return false;
  //   }
  // }  
  return false;
};





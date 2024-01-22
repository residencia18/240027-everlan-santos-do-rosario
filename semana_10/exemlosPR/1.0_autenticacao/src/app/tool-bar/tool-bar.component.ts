import { Component} from '@angular/core';
import { AutenticacaoService } from '../autenticacao.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tool-bar',
  templateUrl: './tool-bar.component.html',
  styleUrls: ['./tool-bar.component.css']
})
export class ToolBarComponent {
  isLogado: boolean = false;
  

  constructor(private authServico:AutenticacaoService, private router: Router) { 

  }
  ngOnInit(): void {
    this.isLogado = this.authServico.isAutenticado();
  }

  onLogout() {
    if(this.authServico.isAutenticado()) {
      this.authServico.logout();
    }
    //console.log('logout em tool-bar.component.ts');
    //this.authServico.logout();
    //this.router.navigate(['login']);
  }
}

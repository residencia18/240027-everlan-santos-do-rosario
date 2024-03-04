import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FakedataService, Usuarios } from '../fakedata.service';
import { CanComponentDeactivate, CanDeactivateType } from '../desativar.interface';


@Component({
  selector: 'app-edit-usuario',
  templateUrl: './edit-usuario.component.html',
  styleUrls: ['./edit-usuario.component.css']
})
export class EditUsuarioComponent implements OnInit, CanComponentDeactivate  {

  usuario: Usuarios = { id: 0, nome: '', email: '', password:'' }; 
  textoAlterado = false;

  constructor(private route: ActivatedRoute, private dataFakeService: FakedataService, private router: Router) { }
  
  canDeactivate(): CanDeactivateType {
    if(this.textoAlterado){
        const confirma = confirm('O texto foi alterado, deseja sair da página?');
        return confirma;
    }
    else{
      console.log('texto nao alterado, pode sair da pagina!!');
      return true;
    }
  }
  
  ngOnInit(): void {
    //const id = this.route.snapshot.paramMap.get('id');
    this.route.paramMap.subscribe(params => {
      const id  = params.get('id');
      if (id !== null) {
        const user = this.dataFakeService.getUsers().find(user => user.id === +id);
        if (user !== undefined) {
          this.usuario = user;
        }
      }
    });

    
  }

  salvarUsuario(nome: string, email: string, password:string): void {
    if (this.usuario === undefined) {
      return;
    }
    this.dataFakeService.editUser(this.usuario.id, { id: this.usuario.id, nome:nome, email:email, password: password});
    //this.router.navigate(['../'], { relativeTo: this.route });
    this.router.navigate(['/usuarios']);
  }

  AlterouTexto(){
    this.textoAlterado = true;
    console.log("texto alterado: "+ this.textoAlterado);
  }
}

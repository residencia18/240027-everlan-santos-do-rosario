import { Component } from '@angular/core';
import { FakedataService, Usuarios } from '../fakedata.service';
import { Router } from '@angular/router';
import { CanComponentDeactivate, CanDeactivateType } from '../desativar.interface';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent{
  pessoas: Usuarios[] | undefined;

  constructor(private servicoUsuarios: FakedataService,  private router: Router) { }

  ngOnInit(): void {
    this.pessoas = this.servicoUsuarios.getUsers();
    console.log(this.pessoas);
  }

  editUsuario(id: number): void {
    this.router.navigate(['/usuarios', id, 'edit']);
  }

}

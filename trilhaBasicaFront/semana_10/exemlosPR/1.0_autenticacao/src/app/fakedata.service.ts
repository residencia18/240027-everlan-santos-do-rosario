import { Injectable } from '@angular/core';


export interface Usuarios {
  id: number;
  nome: string;
  email: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class FakedataService {

  private users: Usuarios[] = [
    { id: 1, nome: 'Abutre', email: 'abutre@gmail.com', password: '123' },
    { id: 2, nome: 'Zupeto', email: 'zupeto@gmail.com' , password: '123' },
    { id: 3, nome: 'Rossuga', email: 'rossuga@gmail.com' , password: '123' },
  ];

  constructor() { }

  getUsers(): Usuarios[] {
    return this.users;
  }

  insertUser(user: Usuarios): void {
    this.users.push(user);
  }

  editUser(id: number, updatedUser: Usuarios): void {
    const index = this.users.findIndex(user => user.id === id);
    if (index !== -1) {
      this.users[index] = updatedUser;
    }
  }
}

import { Injectable } from '@angular/core';
import { suinoModel } from '../model/suino.model';
import { AngularFireDatabase } from '@angular/fire/compat/database';

@Injectable({
  providedIn: 'root'
})
export class SuinoService {
  error: any;
  

  constructor(private db: AngularFireDatabase) { }

  createSuino(suino: suinoModel) {
    this.db.list('suinos').push(suino).catch(err => this.error = err);
  }

  getAllSuinos() {
    try {
      return this.db.list('suinos').valueChanges();
    } catch (error) {
      this.error = error;
      return null;
    }
    
  }

  getSuino(brinco: number) {
    try {
      return this.db.object(`suinos/${brinco}`).valueChanges();
    }catch (error) {
      this.error = error;
      return null;
    }
    
  }

  updateSuino(suino: suinoModel): void {
    this.db.object(`suinos/${suino.brinco}`).update(suino).catch(err => this.error = err);
  }

  deleteSuino(brinco: number): void {
    this.db.object(`suinos/${brinco}`).remove().catch(err => this.error = err);
  }
}

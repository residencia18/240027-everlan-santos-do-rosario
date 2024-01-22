import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IntervaloSubjectService {

  subject = new Subject<number>();
  constructor() {
    setInterval(() => {
      this.subject.next(Math.random());
    }, 1000);
   }
}

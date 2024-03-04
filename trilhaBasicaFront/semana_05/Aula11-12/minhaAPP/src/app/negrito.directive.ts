import { Directive, HostBinding, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appNegrito]',
  standalone: true
})
export class NegritoDirective {
 
  @Input() corInput: string = 'transparent';

  @Input() cor: string = 'black';

  @HostBinding('style.background') corFundo: string = this.corInput;
  @HostBinding('style.color') cortext: string = this.cor;

  constructor() { }

  @HostListener('mouseenter') onMouseEnter() {
    this.cortext = "red";
    this.corFundo = "orange";
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.cortext = 'white';
    this.corFundo = 'white';
  }

}

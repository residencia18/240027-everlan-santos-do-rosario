import { Directive, HostBinding, HostListener, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appPisca]',
  standalone: true
})
export class PiscaDirective {

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) { }
  @HostBinding('style.background') corFundo: string = "red";
  @HostListener('window:click') onClick() {
    this.corFundo = "green";
  }
}

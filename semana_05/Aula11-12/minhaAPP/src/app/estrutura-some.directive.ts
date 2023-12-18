import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appEstruturaSome]',
  standalone: true
})
export class EstruturaSomeDirective {

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) { }
  
  @Input() set appEstruturaSome(qtd: number) {
    for (let i = 0; i < qtd; i++) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    }
  }
}

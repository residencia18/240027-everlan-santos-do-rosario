import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-nav-item',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './nav-item.component.html',
  styleUrl: './nav-item.component.css'
})
export class NavItemComponent {
  @Input() routerLink: string = ''
  @Input() isActive: boolean = false
}

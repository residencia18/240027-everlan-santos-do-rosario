import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-item-lista',
  standalone: true,
  imports: [],
  templateUrl: './item-lista.component.html',
  styleUrl: './item-lista.component.css'
})
export class ItemListaComponent {
  @Input() movie!: {
    image: string
    title: string
    starRating: string
    rating: string
    year: string
    genre: string
    runtime: string
    cast: string
  }
}

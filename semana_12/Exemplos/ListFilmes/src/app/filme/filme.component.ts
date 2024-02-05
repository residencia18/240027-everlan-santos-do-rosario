import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Router } from 'express';

@Component({
  selector: 'app-filme',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './filme.component.html',
  styleUrl: './filme.component.css'
})
export class FilmeComponent {
  @Input() movies!: {
    image: string
    title: string
    starRating: string
    rating: string
    year: string
    genre: string
    runtime: string
    cast: string
  }[]
}

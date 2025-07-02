import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cafe',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cafe.component.html',
  styleUrls: ['./cafe.component.css']
})
export class CafeComponent {} // <-- este nome é o que precisa bater com o import

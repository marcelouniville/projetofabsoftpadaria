import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bolo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bolo.component.html',
  styleUrls: ['./bolo.component.css']
})
export class BoloComponent {} // <-- este nome é o que precisa bater com o import

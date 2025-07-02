import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  menuOpen = false;
  produtosOpen = false;

  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  toggleProdutos(event: Event) {
    event.preventDefault();
    this.produtosOpen = !this.produtosOpen;
  }
}

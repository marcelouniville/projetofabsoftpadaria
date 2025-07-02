import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Produto, ProdutoService } from '../../service/produto.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-estoque-cafe',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './estoque-cafe.component.html',
  styleUrls: ['./estoque-cafe.component.css']
})
export class EstoqueCafeComponent implements OnInit {
  cafes: Produto[] = [];

  constructor(private produtoService: ProdutoService) {}

  ngOnInit(): void {
    this.carregarCafes();
  }

  carregarCafes() {
    this.produtoService.listar().subscribe(produtos => {
      this.cafes = produtos.filter(p => p.nome.toLowerCase().includes('café'));
    });
  }

  excluir(cafe: Produto) {
    if (cafe.id && confirm(`Deseja excluir o café "${cafe.nome}"?`)) {
      this.produtoService.excluir(cafe.id).subscribe(() => {
        this.carregarCafes();
      });
    }
  }
}

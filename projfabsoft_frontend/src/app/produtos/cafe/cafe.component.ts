import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProdutoService, Produto } from '../../service/produto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cafe',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './cafe.component.html',
  styleUrls: ['./cafe.component.css']
})
export class CafeComponent implements OnInit {
  cafes: Produto[] = [];

  constructor(private produtoService: ProdutoService, private router: Router) {}

  ngOnInit(): void {
    this.carregarCafes();
  }

  carregarCafes() {
    this.produtoService.listar().subscribe(produtos => {
      this.cafes = produtos.filter(p => p.nome.toLowerCase().includes('cafe') || p.nome.toLowerCase().includes('café'));
    }, err => {
      console.error('Erro ao carregar cafés', err);
    });
  }

  excluir(cafe: Produto) {
    if (cafe.id && confirm(`Confirma exclusão do café ${cafe.nome}?`)) {
      this.produtoService.excluir(cafe.id).subscribe(() => {
        alert('Café excluído com sucesso!');
        this.carregarCafes();
      }, err => {
        alert('Erro ao excluir café');
        console.error(err);
      });
    }
  }
}

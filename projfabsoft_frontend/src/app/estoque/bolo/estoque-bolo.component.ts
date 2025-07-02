import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Produto, ProdutoService } from '../../service/produto.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-estoque-bolo',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './estoque-bolo.component.html',
  styleUrls: ['./estoque-bolo.component.css']
})
export class EstoqueBoloComponent implements OnInit {
  bolos: Produto[] = [];

  constructor(private produtoService: ProdutoService) {}

  ngOnInit(): void {
    this.carregarBolos();
  }

  carregarBolos() {
    this.produtoService.listar().subscribe(produtos => {
      this.bolos = produtos.filter(p => p.nome.toLowerCase().includes('bolo'));
    });
  }

  excluir(bolo: Produto) {
    if (bolo.id && confirm(`Deseja excluir o bolo "${bolo.nome}"?`)) {
      this.produtoService.excluir(bolo.id).subscribe(() => {
        this.carregarBolos();
      });
    }
  }
}

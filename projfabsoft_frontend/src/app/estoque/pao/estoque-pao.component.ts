import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Produto, ProdutoService } from '../../service/produto.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-estoque-pao',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './estoque-pao.component.html',
  styleUrls: ['./estoque-pao.component.css']
})
export class EstoquePaoComponent implements OnInit {
  paes: Produto[] = [];

  constructor(private produtoService: ProdutoService) {}

  ngOnInit(): void {
    this.carregarPaes();
  }

  carregarPaes() {
    this.produtoService.listar().subscribe(produtos => {
      this.paes = produtos.filter(p => p.nome.toLowerCase().includes('pão'));
    });
  }

  excluir(pao: Produto) {
    if (pao.id && confirm(`Deseja excluir o pão "${pao.nome}"?`)) {
      this.produtoService.excluir(pao.id).subscribe(() => {
        this.carregarPaes();
      });
    }
  }
}

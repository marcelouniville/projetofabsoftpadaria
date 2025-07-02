import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProdutoService, Produto } from '../../service/produto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bolo',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './bolo.component.html',
  styleUrls: ['./bolo.component.css']
})
export class BoloComponent implements OnInit {
  bolos: Produto[] = [];

  constructor(private produtoService: ProdutoService, private router: Router) {}

  ngOnInit(): void {
    this.carregarBolos();
  }

  carregarBolos() {
    this.produtoService.listar().subscribe(produtos => {
      this.bolos = produtos.filter(p => p.nome.toLowerCase().includes('bolo'));
    }, err => {
      console.error('Erro ao carregar bolos', err);
    });
  }

  excluir(bolo: Produto) {
    if (bolo.id && confirm(`Confirma exclusão do ${bolo.nome}?`)) {
      this.produtoService.excluir(bolo.id).subscribe(() => {
        alert('Bolo excluído com sucesso!');
        this.carregarBolos();
      }, err => {
        alert('Erro ao excluir bolo');
        console.error(err);
      });
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProdutoService, Produto } from '../../service/produto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pao',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './pao.component.html',
  styleUrls: ['./pao.component.css']
})
export class PaoComponent implements OnInit {
  paes: Produto[] = [];

  constructor(private produtoService: ProdutoService, private router: Router) {}

  ngOnInit(): void {
    this.carregarPaes();
  }

  carregarPaes() {
    this.produtoService.listar().subscribe(produtos => {
      this.paes = produtos.filter(p =>
        this.removerAcentos(p.nome.toLowerCase()).includes('pao')
      );
    }, err => {
      console.error('Erro ao carregar pães', err);
    });
  }

  excluir(pao: Produto) {
    if (pao.id && confirm(`Confirma exclusão do ${pao.nome}?`)) {
      this.produtoService.excluir(pao.id).subscribe(() => {
        alert('Pão excluído com sucesso!');
        this.carregarPaes();
      }, err => {
        alert('Erro ao excluir pão');
        console.error(err);
      });
    }
  }

  removerAcentos(str: string) {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
  }
}

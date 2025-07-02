import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProdutoService, Produto } from '../../service/produto.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-pao',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './form-pao.component.html',
  styleUrls: ['./form-pao.component.css']
})
export class FormPaoComponent implements OnInit {
  pao: Produto = {
    nome: '',
    quantidadeEstoque: 0,
    preco: 0
  };
  id: number | null = null;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private produtoService: ProdutoService
  ) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if (this.id) {
      this.produtoService.buscarPorId(this.id).subscribe(p => {
        this.pao = {
          nome: p.nome,
          quantidadeEstoque: p.quantidadeEstoque,
          preco: p.preco ?? 0,
          id: p.id
        };
      });
    }
  }

  salvar() {
    const paoParaSalvar: Produto = {
      id: this.pao.id,
      nome: this.pao.nome,
      quantidadeEstoque: this.pao.quantidadeEstoque,
      preco: this.pao.preco
    };

    this.produtoService.salvar(paoParaSalvar).subscribe(() => {
      alert('Pão salvo com sucesso!');
      this.router.navigate(['/produtos/pao']);
    });
  }

  cancelar() {
    this.router.navigate(['/produtos/pao']);
  }
}

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
    descricao: '',
    preco: 0,
    quantidadeEstoque: 0,
    horario: ''
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
        this.pao = p;
      });
    }
  }

  salvar() {
    this.produtoService.salvar(this.pao).subscribe(() => {
      alert('Pão salvo com sucesso!');
      this.router.navigate(['/produtos/pao']);
    });
  }

  cancelar() {
    this.router.navigate(['/produtos/pao']);
  }
}

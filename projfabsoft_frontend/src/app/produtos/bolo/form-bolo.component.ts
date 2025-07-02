import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProdutoService, Produto } from '../../service/produto.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-bolo',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './form-bolo.component.html',
  styleUrls: ['./form-bolo.component.css']
})
export class FormBoloComponent implements OnInit {
  bolo: Produto = {
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
      this.produtoService.buscarPorId(this.id).subscribe(b => {
        this.bolo = b;
      });
    }
  }

  salvar() {
    this.produtoService.salvar(this.bolo).subscribe(() => {
      alert('Bolo salvo com sucesso!');
      this.router.navigate(['/produtos/bolo']);
    });
  }

  cancelar() {
    this.router.navigate(['/produtos/bolo']);
  }
}

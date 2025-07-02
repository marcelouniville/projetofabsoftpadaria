import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProdutoService, Produto } from '../../service/produto.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-cafe',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './form-cafe.component.html',
  styleUrls: ['./form-cafe.component.css']
})
export class FormCafeComponent implements OnInit {
  cafe: Produto = {
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
      this.produtoService.buscarPorId(this.id).subscribe(prod => {
        this.cafe = prod;
      });
    }
  }

  salvar() {
    this.produtoService.salvar(this.cafe).subscribe(() => {
      alert('Café salvo com sucesso!');
      this.router.navigate(['/produtos/cafe']);
    }, err => {
      alert('Erro ao salvar café');
      console.error(err);
    });
  }

  cancelar() {
    this.router.navigate(['/produtos/cafe']);
  }
}

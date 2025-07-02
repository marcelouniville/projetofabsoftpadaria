import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Produto {
  id?: number;
  nome: string;
  descricao?: string;      // deixou opcional
  preco?: number;          // deixou opcional
  quantidadeEstoque: number;
  horario?: string;        // deixou opcional
}

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private apiUrl = 'http://localhost:8080/api/v1/produtos';

  constructor(private http: HttpClient) {}

  listar(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.apiUrl);
  }

  buscarPorId(id: number): Observable<Produto> {
    return this.http.get<Produto>(`${this.apiUrl}/${id}`);
  }

  salvar(produto: Produto): Observable<Produto> {
    if (produto.id) {
      return this.http.put<Produto>(`${this.apiUrl}/${produto.id}`, produto);
    } else {
      return this.http.post<Produto>(this.apiUrl, produto);
    }
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

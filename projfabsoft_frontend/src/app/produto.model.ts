export interface Produto {
  id?: number;            // id opcional (gerado pelo backend)
  nome: string;           // nome do produto (ex: Pão Francês)
  descricao: string;      // descrição curta (ex: Pão fresquinho)
  preco: number;          // preço em reais
  quantidadeEstoque: number; // quantidade em estoque (pode usar para "horário" se quiser)
}

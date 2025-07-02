package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.Produto;
import java.util.List;

public interface ProdutoService {
    List<Produto> listarTodos();
    Produto salvar(Produto produto);
    void deletar(long id);
    Produto buscarPorId(long id);
}

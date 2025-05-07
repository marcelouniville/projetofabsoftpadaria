package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.Produto;
import java.util.List;

public interface ProdutoService {
    Produto save(Produto produto);
    List<Produto> getAll();
    Produto getById(long id);
    boolean delete(long id);
}

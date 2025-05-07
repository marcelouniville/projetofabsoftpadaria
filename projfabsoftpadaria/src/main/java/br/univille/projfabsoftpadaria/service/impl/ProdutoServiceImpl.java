package br.univille.projfabsoftpadaria.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftpadaria.entity.Produto;
import br.univille.projfabsoftpadaria.repository.ProdutoRepository;
import br.univille.projfabsoftpadaria.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @Override
    public Produto getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(long id) {
        Produto produto = getById(id);
        if (produto != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

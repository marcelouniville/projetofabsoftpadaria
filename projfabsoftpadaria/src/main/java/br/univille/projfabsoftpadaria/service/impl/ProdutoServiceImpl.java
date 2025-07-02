package br.univille.projfabsoftpadaria.service.impl;

import br.univille.projfabsoftpadaria.entity.Produto;
import br.univille.projfabsoftpadaria.service.ProdutoService;
import br.univille.projfabsoftpadaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deletar(long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto buscarPorId(long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}

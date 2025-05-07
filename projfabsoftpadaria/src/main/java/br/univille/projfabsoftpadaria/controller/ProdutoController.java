package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Produto;
import br.univille.projfabsoftpadaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAll() {
        return produtoService.getAll();
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return produtoService.delete(id);
    }
}

package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Produto;
import br.univille.projfabsoftpadaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.getAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // Endpoint para criar um novo produto
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        if (produto == null) {
            return ResponseEntity.badRequest().build();
        }
        produtoService.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable long id, @RequestBody Produto produto) {
        if (id <= 0 || produto == null) {
            return ResponseEntity.badRequest().build();
        }

        Produto existingProduto = produtoService.getById(id);
        if (existingProduto == null) {
            return ResponseEntity.notFound().build();
        }

        existingProduto.setNome(produto.getNome());
        existingProduto.setDescricao(produto.getDescricao());
        existingProduto.setPreco(produto.getPreco());
        existingProduto.setQuantidadeEstoque(produto.getQuantidadeEstoque());

        produtoService.save(existingProduto);
        return new ResponseEntity<>(existingProduto, HttpStatus.OK);
    }

    // Endpoint para deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Produto produto = produtoService.getById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        produtoService.delete(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}

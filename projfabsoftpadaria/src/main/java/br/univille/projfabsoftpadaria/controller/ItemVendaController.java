package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.ItemVenda;
import br.univille.projfabsoftpadaria.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itemvenda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    // Endpoint para listar todos os itens de venda
    @GetMapping
    public ResponseEntity<List<ItemVenda>> getAllItemVenda() {
        List<ItemVenda> itemVendas = itemVendaService.getAll();
        return new ResponseEntity<>(itemVendas, HttpStatus.OK);
    }

    // Endpoint para criar um novo item de venda
    @PostMapping
    public ResponseEntity<ItemVenda> createItemVenda(@RequestBody ItemVenda itemVenda) {
        if (itemVenda == null) {
            return ResponseEntity.badRequest().build();
        }
        itemVendaService.save(itemVenda);
        return new ResponseEntity<>(itemVenda, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um item de venda
    @PutMapping("/{id}")
    public ResponseEntity<ItemVenda> updateItemVenda(@PathVariable long id, @RequestBody ItemVenda itemVenda) {
        if (id <= 0 || itemVenda == null) {
            return ResponseEntity.badRequest().build();
        }

        ItemVenda existingItemVenda = itemVendaService.getById(id);
        if (existingItemVenda == null) {
            return ResponseEntity.notFound().build();
        }

        existingItemVenda.setQuantidade(itemVenda.getQuantidade());
        existingItemVenda.setPrecoUnitario(itemVenda.getPrecoUnitario());
        existingItemVenda.setProduto(itemVenda.getProduto());
        existingItemVenda.setVenda(itemVenda.getVenda());

        itemVendaService.save(existingItemVenda);
        return new ResponseEntity<>(existingItemVenda, HttpStatus.OK);
    }

    // Endpoint para deletar um item de venda
    @DeleteMapping("/{id}")
    public ResponseEntity<ItemVenda> deleteItemVenda(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        ItemVenda itemVenda = itemVendaService.getById(id);
        if (itemVenda == null) {
            return ResponseEntity.notFound().build();
        }

        itemVendaService.delete(id);
        return new ResponseEntity<>(itemVenda, HttpStatus.OK);
    }
}

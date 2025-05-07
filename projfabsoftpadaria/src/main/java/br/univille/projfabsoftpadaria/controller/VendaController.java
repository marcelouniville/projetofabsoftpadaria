package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Venda;
import br.univille.projfabsoftpadaria.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    // Endpoint para listar todas as vendas
    @GetMapping
    public ResponseEntity<List<Venda>> getVendas() {
        List<Venda> vendas = service.getAll();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    // Endpoint para criar uma nova venda
    @PostMapping
    public ResponseEntity<Venda> postVenda(@RequestBody Venda venda) {
        if (venda == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(venda);
        return new ResponseEntity<>(venda, HttpStatus.CREATED);
    }

    // Endpoint para atualizar uma venda existente
    @PutMapping("/{id}")
    public ResponseEntity<Venda> putVenda(@PathVariable long id, @RequestBody Venda venda) {
        if (id <= 0 || venda == null) {
            return ResponseEntity.badRequest().build();
        }

        // Verifica se a venda com o id existe
        Venda vendaExistente = service.getById(id);
        if (vendaExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Atualiza os dados da venda existente
        vendaExistente.setData(venda.getData());
        vendaExistente.setItens(venda.getItens());
        // Você pode adicionar outros campos de venda, como pagamento, cliente, etc.

        service.save(vendaExistente);
        return new ResponseEntity<>(vendaExistente, HttpStatus.OK);
    }

    // Endpoint para excluir uma venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        boolean deleted = service.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}

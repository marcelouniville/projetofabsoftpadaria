package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Pedido;
import br.univille.projfabsoftpadaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoint para listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Endpoint para criar um novo pedido
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        if (pedido == null) {
            return ResponseEntity.badRequest().build();
        }
        pedidoService.save(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable long id, @RequestBody Pedido pedido) {
        if (id <= 0 || pedido == null) {
            return ResponseEntity.badRequest().build();
        }

        Pedido existingPedido = pedidoService.getById(id);
        if (existingPedido == null) {
            return ResponseEntity.notFound().build();
        }

        existingPedido.setHorarioRetirada(pedido.getHorarioRetirada());
        existingPedido.setProdutos(pedido.getProdutos());

        pedidoService.save(existingPedido);
        return new ResponseEntity<>(existingPedido, HttpStatus.OK);
    }

    // Endpoint para deletar um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Pedido pedido = pedidoService.getById(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        pedidoService.delete(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}

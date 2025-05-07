package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Pedido;
import br.univille.projfabsoftpadaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAll() {
        return pedidoService.getAll();
    }

    @PostMapping
    public Pedido save(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoService.save(pedido);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return pedidoService.delete(id);
    }
}

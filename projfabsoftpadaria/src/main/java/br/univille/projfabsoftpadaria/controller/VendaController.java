package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Venda;
import br.univille.projfabsoftpadaria.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAll() {
        return vendaService.getAll();
    }

    @PostMapping
    public Venda save(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

    @PutMapping("/{id}")
    public Venda update(@PathVariable long id, @RequestBody Venda venda) {
        venda.setId(id);
        return vendaService.save(venda);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return vendaService.delete(id);
    }
}

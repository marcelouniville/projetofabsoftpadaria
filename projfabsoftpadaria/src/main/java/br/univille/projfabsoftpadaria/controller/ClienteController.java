package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.Cliente;
import br.univille.projfabsoftpadaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET: Lista todos os clientes
    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    // POST: Cria um novo cliente
    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    // PUT: Atualiza um cliente existente
    @PutMapping("/{id}")
    public Cliente update(@PathVariable long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteService.save(cliente);
    }

    // DELETE: Deleta um cliente existente
    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable long id) {
        return clienteService.delete(id);
    }
}


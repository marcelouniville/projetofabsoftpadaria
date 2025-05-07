package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.entity.RelatorioDiario;
import br.univille.projfabsoftpadaria.service.RelatorioDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/relatorios")
public class RelatorioDiarioController {

    @Autowired
    private RelatorioDiarioService relatorioDiarioService;

    @GetMapping
    public List<RelatorioDiario> getAll() {
        return relatorioDiarioService.getAll();
    }

    @GetMapping("/{data}")
    public RelatorioDiario getByData(@PathVariable LocalDate data) {
        return relatorioDiarioService.getByData(data);
    }

    @PostMapping
    public RelatorioDiario save(@RequestBody RelatorioDiario relatorioDiario) {
        return relatorioDiarioService.save(relatorioDiario);
    }

    @DeleteMapping("/{id}")
    public RelatorioDiario delete(@PathVariable long id) {
        return relatorioDiarioService.delete(id);
    }
}


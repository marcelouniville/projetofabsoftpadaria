package br.univille.projfabsoftpadaria.controller;

import br.univille.projfabsoftpadaria.service.RelatorioDiarioService;
import br.univille.projfabsoftpadaria.entity.RelatorioDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/relatorios")
public class RelatorioDiarioController {

    @Autowired
    private RelatorioDiarioService relatorioDiarioService;

    // Endpoint para obter todos os relatórios diários
    @GetMapping
    public ResponseEntity<List<RelatorioDiario>> getAllRelatorios() {
        List<RelatorioDiario> relatorios = relatorioDiarioService.getAll();
        return new ResponseEntity<>(relatorios, HttpStatus.OK);
    }

    // Endpoint para obter um relatório diário específico pelo dia
    @GetMapping("/{data}")
    public ResponseEntity<RelatorioDiario> getRelatorioByData(@PathVariable String data) {
        LocalDate localDate = LocalDate.parse(data);
        RelatorioDiario relatorio = relatorioDiarioService.getByData(localDate);
        if (relatorio != null) {
            return new ResponseEntity<>(relatorio, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

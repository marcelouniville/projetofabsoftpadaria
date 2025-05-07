package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.RelatorioDiario;

import java.time.LocalDate;
import java.util.List;

public interface RelatorioDiarioService {

    // Método para obter todos os relatórios
    List<RelatorioDiario> getAll();

    // Método para obter um relatório específico por data
    RelatorioDiario getByData(LocalDate data);

    RelatorioDiario delete(long id);

    RelatorioDiario save(RelatorioDiario relatorioDiario);
}

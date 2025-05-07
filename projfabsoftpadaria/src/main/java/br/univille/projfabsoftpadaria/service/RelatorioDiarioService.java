package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.RelatorioDiario;

import java.util.List;

public interface RelatorioDiarioService {
    List<RelatorioDiario> getAll();
    RelatorioDiario getById(long id);
    RelatorioDiario save(RelatorioDiario relatorio);
    boolean delete(long id);
}

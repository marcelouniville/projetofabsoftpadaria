package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.Venda;

import java.util.List;

public interface VendaService {
    List<Venda> getAll();
    Venda getById(long id);
    Venda save(Venda venda);
    boolean delete(long id);
}

package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.ItemVenda;
import java.util.List;

public interface ItemVendaService {
    ItemVenda save(ItemVenda itemVenda);
    List<ItemVenda> getAll();
    ItemVenda getById(long id);
    boolean delete(long id);
}

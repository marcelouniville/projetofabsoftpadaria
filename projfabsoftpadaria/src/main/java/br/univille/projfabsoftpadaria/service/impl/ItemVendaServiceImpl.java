package br.univille.projfabsoftpadaria.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftpadaria.entity.ItemVenda;
import br.univille.projfabsoftpadaria.repository.ItemVendaRepository;
import br.univille.projfabsoftpadaria.service.ItemVendaService;

@Service
public class ItemVendaServiceImpl implements ItemVendaService {

    @Autowired
    private ItemVendaRepository repository;

    @Override
    public ItemVenda save(ItemVenda itemVenda) {
        return repository.save(itemVenda);
    }

    @Override
    public List<ItemVenda> getAll() {
        return repository.findAll();
    }

    @Override
    public ItemVenda getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(long id) {
        var item = getById(id);
        if (item != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

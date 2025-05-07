package br.univille.projfabsoftpadaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftpadaria.entity.Venda;
import br.univille.projfabsoftpadaria.repository.VendaRepository;
import br.univille.projfabsoftpadaria.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repository;

    @Override
    public List<Venda> getAll() {
        return repository.findAll();
    }

    @Override
    public Venda getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Venda save(Venda venda) {
        return repository.save(venda);
    }

    @Override
    public boolean delete(long id) {
        var venda = getById(id);
        if (venda != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

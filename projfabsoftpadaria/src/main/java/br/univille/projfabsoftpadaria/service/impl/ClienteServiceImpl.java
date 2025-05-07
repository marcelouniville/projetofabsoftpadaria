package br.univille.projfabsoftpadaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftpadaria.entity.Cliente;
import br.univille.projfabsoftpadaria.repository.ClienteRepository;
import br.univille.projfabsoftpadaria.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
        
    }

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
        return retorno.get();

        return null;
    }

    @Override
    public Cliente delete(long id) {
       var cliente = getById(id);
       if(cliente != null)
        repository.deleteById(id);
        return cliente;

    }

}

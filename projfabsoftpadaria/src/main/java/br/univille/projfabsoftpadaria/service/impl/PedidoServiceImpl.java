package br.univille.projfabsoftpadaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftpadaria.entity.Pedido;
import br.univille.projfabsoftpadaria.repository.PedidoRepository;
import br.univille.projfabsoftpadaria.service.PedidoService;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public List<Pedido> getAll() {
        return repository.findAll();
    }

    @Override
    public Pedido getById(long id) {
        var retorno = repository.findById(id);
        return retorno.orElse(null);
    }

    @Override
    public boolean delete(long id) {
        var pedido = getById(id);
        if (pedido != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

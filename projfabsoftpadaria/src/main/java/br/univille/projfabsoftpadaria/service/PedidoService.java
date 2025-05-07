package br.univille.projfabsoftpadaria.service;

import br.univille.projfabsoftpadaria.entity.Pedido;
import java.util.List;

public interface PedidoService {
    Pedido save(Pedido pedido);
    List<Pedido> getAll();
    Pedido getById(long id);
    boolean delete(long id);
}

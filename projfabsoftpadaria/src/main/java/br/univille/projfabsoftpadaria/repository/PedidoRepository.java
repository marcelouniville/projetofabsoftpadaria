package br.univille.projfabsoftpadaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.projfabsoftpadaria.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

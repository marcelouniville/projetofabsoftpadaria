package br.univille.projfabsoftpadaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.projfabsoftpadaria.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

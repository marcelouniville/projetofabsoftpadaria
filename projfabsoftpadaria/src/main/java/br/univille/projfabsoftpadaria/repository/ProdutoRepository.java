package br.univille.projfabsoftpadaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.projfabsoftpadaria.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

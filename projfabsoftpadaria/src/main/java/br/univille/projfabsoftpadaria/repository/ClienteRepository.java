package br.univille.projfabsoftpadaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftpadaria.entity.Cliente;

@Repository
public interface ClienteRepository
         extends JpaRepository<Cliente,Long> {

}

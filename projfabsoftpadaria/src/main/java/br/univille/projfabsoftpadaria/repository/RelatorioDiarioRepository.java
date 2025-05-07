package br.univille.projfabsoftpadaria.repository;

import br.univille.projfabsoftpadaria.entity.RelatorioDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RelatorioDiarioRepository extends JpaRepository<RelatorioDiario, Long> {

    // Define o método findByData que vai buscar o RelatorioDiario pela data
    RelatorioDiario findByData(LocalDate data);
}

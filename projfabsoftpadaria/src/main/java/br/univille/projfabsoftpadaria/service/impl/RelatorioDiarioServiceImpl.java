package br.univille.projfabsoftpadaria.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftpadaria.entity.RelatorioDiario;
import br.univille.projfabsoftpadaria.repository.RelatorioDiarioRepository;
import br.univille.projfabsoftpadaria.service.RelatorioDiarioService;

@Service
public class RelatorioDiarioServiceImpl implements RelatorioDiarioService {

    @Autowired
    private RelatorioDiarioRepository repository;

    @Override
    public List<RelatorioDiario> getAll() {
        return repository.findAll();
    }

    @Override
    public RelatorioDiario getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RelatorioDiario save(RelatorioDiario relatorio) {
        relatorio.calcularResumo(); // Garante que o resumo seja atualizado
        return repository.save(relatorio);
    }

    @Override
    public boolean delete(long id) {
        var relatorio = getById(id);
        if (relatorio != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

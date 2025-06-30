package br.univille.projfabsoftpadaria.service.impl;

import br.univille.projfabsoftpadaria.entity.RelatorioDiario;
import br.univille.projfabsoftpadaria.repository.RelatorioDiarioRepository;
import br.univille.projfabsoftpadaria.service.RelatorioDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioDiarioServiceImpl implements RelatorioDiarioService {

    @Autowired
    private RelatorioDiarioRepository relatorioDiarioRepository;

    @Override
    public List<RelatorioDiario> getAll() {
        return relatorioDiarioRepository.findAll();
    }

    // A implementação do método getByData
    @Override
    public RelatorioDiario getByData(LocalDate data) {
        return relatorioDiarioRepository.findByData(data);
    }

    @Override
    public RelatorioDiario delete(long id) {
       
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public RelatorioDiario save(RelatorioDiario relatorioDiario) {
        
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}

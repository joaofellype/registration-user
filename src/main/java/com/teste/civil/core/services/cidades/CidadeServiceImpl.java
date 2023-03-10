package com.teste.civil.core.services.cidades;

import com.teste.civil.application.dto.cidades.CidadeDto;
import com.teste.civil.core.repository.cidades.CidadeRepository;
import com.teste.civil.core.shared.exceptions.NotFoundException;
import com.teste.civil.core.shared.validators.ListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeServiceImpl(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Override
    public List<CidadeDto> findByUf(String uf) {
        var cid_uf = uf;
        var cidades = cidadeRepository.findByCidUf(cid_uf).stream().map(e -> new CidadeDto(e.getCidId(), e.getCidNome(), e.getCidUf())).toList();
        if (ListValidator.isEmpty(cidades)) throw new NotFoundException("Nenhuma cidade encontrada");
        return cidades;
    }

    @Override
    public CidadeDto findOne(Long id) {
        var cidade = cidadeRepository.findById(id).orElseThrow(() -> new NotFoundException("Cidade não encontrada"));
        return new CidadeDto(cidade.getCidId(), cidade.getCidNome(), cidade.getCidUf());
    }
}

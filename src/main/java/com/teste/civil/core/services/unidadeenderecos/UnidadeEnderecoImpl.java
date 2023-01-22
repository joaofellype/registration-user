package com.teste.civil.core.services.unidadeenderecos;

import com.teste.civil.core.domain.aggregates.unidadeenderecos.UnidadeEndereco;
import com.teste.civil.core.repository.unidadeenderecos.UnidadeEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeEnderecoImpl implements  UnidadeEnderecoService{

    private UnidadeEnderecoRepository unidadeEnderecoRepository;
    @Autowired
    public UnidadeEnderecoImpl(UnidadeEnderecoRepository unidadeEnderecoRepository) {
        this.unidadeEnderecoRepository = unidadeEnderecoRepository;
    }

    @Override
    public void save(Long unidId, Long endId) {

        var unidadeEndereco = UnidadeEndereco.create(unidId,endId);

        unidadeEnderecoRepository.save(unidadeEndereco);
    }
}

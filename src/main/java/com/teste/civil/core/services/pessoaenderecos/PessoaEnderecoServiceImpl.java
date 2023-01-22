package com.teste.civil.core.services.pessoaenderecos;

import com.teste.civil.core.domain.aggregates.pessoaenderecos.PessoaEndereco;
import com.teste.civil.core.repository.pessoaendereco.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaEnderecoServiceImpl implements PessoaEnderecoService {

    private PessoaEnderecoRepository pessoaEnderecoRepository;
    @Autowired
    public PessoaEnderecoServiceImpl(PessoaEnderecoRepository pessoaEnderecoRepository) {
        this.pessoaEnderecoRepository = pessoaEnderecoRepository;
    }

    @Override
    public void save(Long pesId, Long endId) {

        var pessoaEndereco = PessoaEndereco.create(pesId,endId);
        pessoaEnderecoRepository.save(pessoaEndereco);
    }
}

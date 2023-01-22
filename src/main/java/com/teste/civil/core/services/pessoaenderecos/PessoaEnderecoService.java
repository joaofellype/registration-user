package com.teste.civil.core.services.pessoaenderecos;

import com.teste.civil.core.domain.aggregates.pessoaenderecos.PessoaEndereco;

public interface PessoaEnderecoService {

    void save(Long pesId, Long endId);
}

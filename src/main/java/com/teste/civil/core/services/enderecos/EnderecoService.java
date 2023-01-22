package com.teste.civil.core.services.enderecos;

import com.teste.civil.application.dto.enderecos.EnderecoDto;
import com.teste.civil.core.domain.aggregates.enderecos.Endereco;

public interface EnderecoService {


    Endereco save(EnderecoDto enderecoDto);
}

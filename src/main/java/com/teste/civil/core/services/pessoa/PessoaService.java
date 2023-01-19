package com.teste.civil.core.services.pessoa;

import com.teste.civil.application.pessoas.PessoaDto;
import com.teste.civil.core.domain.aggregates.pessoa.Sexo;

public interface PessoaService {

    Long create(PessoaDto pessoaDto);

}

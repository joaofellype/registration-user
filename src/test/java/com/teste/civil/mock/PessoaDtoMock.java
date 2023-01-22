package com.teste.civil.mock;

import com.teste.civil.application.dto.pessoas.PessoaDto;

public class PessoaDtoMock {

    public static PessoaDto create() {
        var pessoaDto = new PessoaDto();

        pessoaDto.setPesNome("Joao Fellype");
        pessoaDto.setPesMae("Joselena");
        pessoaDto.setPesDataNascimento("05-05-2022");
        pessoaDto.setTypeServidor(1);
        pessoaDto.setServidorTemporarioDto(ServidorTemporarioMock.create());
        return pessoaDto;
    }
}

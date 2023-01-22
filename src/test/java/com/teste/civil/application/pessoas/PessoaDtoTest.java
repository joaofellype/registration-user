package com.teste.civil.application.pessoas;

import com.teste.civil.application.dto.pessoas.PessoaDto;
import com.teste.civil.mock.PessoaDtoMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PessoaDtoTest {

    @Test
    void shouldCreatePessoaDto() {

        PessoaDto pessoaDto = PessoaDtoMock.create();

        assertNotNull(pessoaDto);
        assertEquals(1, pessoaDto.getTypeServidor());
    }


}
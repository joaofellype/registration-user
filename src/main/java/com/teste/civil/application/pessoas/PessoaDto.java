package com.teste.civil.application.pessoas;

import com.teste.civil.application.servidorEfetivos.ServidorEfetivoDto;
import com.teste.civil.application.servidorTemporarios.ServidorTemporarioDto;
import com.teste.civil.core.domain.aggregates.pessoa.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {

    private String pesNome;
    private String pesDataNascimento;
    private Sexo pesSexo;
    private String pesMae;
    private String pesPai;
    private ServidorTemporarioDto servidorTemporarioDto;
    private ServidorEfetivoDto servidorEfetivoDto;
    private int typeServidor;


}

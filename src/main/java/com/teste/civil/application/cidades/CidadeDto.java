package com.teste.civil.application.cidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CidadeDto {

    private Long cidId;
    private String cidNome;
    private String ciUf;
}

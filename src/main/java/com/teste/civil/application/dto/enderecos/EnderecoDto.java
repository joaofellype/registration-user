package com.teste.civil.application.dto.enderecos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {

    private String endTipoLogradouro;
    private String endLogradouro;
    private String bairro;
    private Long cidId;
    private int endNumero;

}

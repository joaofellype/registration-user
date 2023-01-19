package com.teste.civil.application.servidorTemporarios;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServidorTemporarioDto {

    private LocalDateTime stDataAdmissao;
    private LocalDateTime stDataDemissao;
}

package com.teste.civil.mock;

import com.teste.civil.application.dto.servidorTemporarios.ServidorTemporarioDto;

import java.time.LocalDateTime;

public class ServidorTemporarioMock {

    public static ServidorTemporarioDto create() {

        var servidorTemporarioDto = new ServidorTemporarioDto();
        servidorTemporarioDto.setStDataAdmissao(LocalDateTime.parse("2015-08-04T10:11:30"));
        servidorTemporarioDto.setStDataDemissao(LocalDateTime.parse("2015-08-04T10:11:30"));
        return servidorTemporarioDto;
    }
}

package com.teste.civil.core.services.cidades;

import com.teste.civil.application.dto.cidades.CidadeDto;

import java.util.List;

public interface CidadeService {

    List<CidadeDto> findByUf(String uf);

    CidadeDto findOne(Long id);
}

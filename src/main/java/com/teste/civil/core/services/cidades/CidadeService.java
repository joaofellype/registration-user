package com.teste.civil.core.services.cidades;

import com.teste.civil.application.cidades.CidadeDto;
import com.teste.civil.core.domain.aggregates.cidades.Cidade;

import java.util.List;

public interface CidadeService {

    List<CidadeDto> findByUf(String uf);
    CidadeDto findOne(Long id);
}

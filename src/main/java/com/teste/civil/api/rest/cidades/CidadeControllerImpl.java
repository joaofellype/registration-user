package com.teste.civil.api.rest.cidades;

import com.teste.civil.application.cidades.CidadeDto;
import com.teste.civil.core.services.cidades.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CidadeControllerImpl implements CidadeController {

    private CidadeService cidadeService;

    @Autowired
    public CidadeControllerImpl(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @Override
    public ResponseEntity<List<CidadeDto>> findCidadeByUf(String uf) {
        return ResponseEntity.ok(cidadeService.findByUf(uf));
    }

    @Override
    public ResponseEntity<CidadeDto> findByCidade(Long id) {
        return ResponseEntity.ok(cidadeService.findOne(id));
    }
}

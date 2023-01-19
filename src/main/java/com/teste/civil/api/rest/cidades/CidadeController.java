package com.teste.civil.api.rest.cidades;

import com.teste.civil.application.cidades.CidadeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CidadeController {

    @GetMapping("/cidade")
    ResponseEntity<List<CidadeDto>> findCidadeByUf(@RequestParam("uf") String uf);
    @GetMapping("/cidade/{id}")
    ResponseEntity<CidadeDto> findByCidade(@PathVariable("id") Long id);
}

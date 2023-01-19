package com.teste.civil.api.rest.pessoa;

import com.teste.civil.application.pessoas.PessoaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PessoaController {

    @PostMapping("/pessoa")
    ResponseEntity<PessoaDto> create(@RequestBody PessoaDto pessoaDto);
}

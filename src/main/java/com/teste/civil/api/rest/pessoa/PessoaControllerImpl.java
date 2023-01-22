package com.teste.civil.api.rest.pessoa;

import com.teste.civil.api.rest.shared.BaseControllerImpl;
import com.teste.civil.application.dto.pessoas.PessoaDto;
import com.teste.civil.core.services.pessoa.PessoaService;
import com.teste.civil.core.services.servidorTemporarios.ServidorTemporarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PessoaControllerImpl extends BaseControllerImpl<PessoaDto> implements PessoaController {

    private PessoaService pessoaService;
    private ServidorTemporarioService servidorTemporarioService;

    public PessoaControllerImpl(PessoaService pessoaService, ServidorTemporarioService servidorTemporarioService) {
        this.pessoaService = pessoaService;
        this.servidorTemporarioService = servidorTemporarioService;
    }

    @Override
    public ResponseEntity<PessoaDto> create(PessoaDto pessoaDto) {

        Long id = pessoaService.create(pessoaDto);
        servidorTemporarioService.create(id, "2015-08-04T10:11:30", "2015-08-04T10:11:30");
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id.toString()).build().toUri();
        return ResponseEntity.created(uri).body(pessoaDto);
    }
}

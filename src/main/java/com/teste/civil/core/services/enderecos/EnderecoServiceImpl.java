package com.teste.civil.core.services.enderecos;

import com.teste.civil.application.dto.enderecos.EnderecoDto;
import com.teste.civil.core.domain.aggregates.enderecos.Endereco;
import com.teste.civil.core.repository.enderecos.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService{

    private EnderecoRepository enderecoRepository;
    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco save(EnderecoDto enderecoDto) {

        var endereco = Endereco.create(enderecoDto.getEndTipoLogradouro(),
                                                enderecoDto.getEndLogradouro(),
                                                enderecoDto.getEndNumero(),
                                                enderecoDto.getBairro(),
                                                enderecoDto.getCidId());


        return enderecoRepository.save(endereco);
    }

}

package com.teste.civil.core.services.pessoa;

import com.teste.civil.application.pessoas.PessoaDto;
import com.teste.civil.core.domain.aggregates.pessoa.Pessoa;
import com.teste.civil.core.domain.aggregates.pessoa.Sexo;
import com.teste.civil.core.domain.aggregates.pessoa.TypeServidor;
import com.teste.civil.core.domain.aggregates.servidorEfetivo.ServidorEfetivo;
import com.teste.civil.core.domain.aggregates.servidorTemporarios.ServidorTemporario;
import com.teste.civil.core.repository.pessoa.PessoaRepository;
import com.teste.civil.core.repository.servidorEfetivo.ServidorEfetivoRepository;
import com.teste.civil.core.repository.servidorTemporarios.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ServidorTemporarioRepository servidorTemporarioRepository;
    private final  ServidorEfetivoRepository servidorEfetivoRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, ServidorTemporarioRepository servidorTemporarioRepository, ServidorEfetivoRepository servidorEfetivoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.servidorTemporarioRepository = servidorTemporarioRepository;
        this.servidorEfetivoRepository = servidorEfetivoRepository;
    }

    @Override
    public Long create(PessoaDto pessoaDto) {

        var dataNascimento = LocalDateTime.parse(pessoaDto.getPesDataNascimento());
        var pessoa = Pessoa.create(pessoaDto.getPesNome(),
                                            dataNascimento,
                                            pessoaDto.getPesSexo().name(),
                                            pessoaDto.getPesPai(),
                                            pessoaDto.getPesMae());

        var result = pessoaRepository.save(pessoa);

        createServidor(pessoaDto, Objects.requireNonNull(TypeServidor.fromInt(pessoaDto.getTypeServidor())),result.getId());

        return result.getId();
    }

    private void createServidor(PessoaDto pessoaDto, TypeServidor typeServidor,Long id){

        if(typeServidor.name().equalsIgnoreCase("Temporario")){
            servidorTemporarioRepository.save(ServidorTemporario.create(id,pessoaDto.getServidorTemporarioDto().getStDataAdmissao(),pessoaDto.getServidorTemporarioDto().getStDataDemissao()));
        }else {
            servidorEfetivoRepository.save(ServidorEfetivo.create(id,pessoaDto.getServidorEfetivoDto().getSeMatricula()));
        }


    }

}

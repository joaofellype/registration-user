package com.teste.civil.core.services.pessoa;

import com.teste.civil.application.dto.enderecos.EnderecoDto;
import com.teste.civil.application.dto.pessoas.PessoaDto;
import com.teste.civil.core.domain.aggregates.enderecos.Endereco;
import com.teste.civil.core.domain.aggregates.pessoa.Pessoa;
import com.teste.civil.core.domain.aggregates.pessoa.TypeServidor;
import com.teste.civil.core.domain.aggregates.pessoaenderecos.PessoaEndereco;
import com.teste.civil.core.domain.aggregates.servidorEfetivo.ServidorEfetivo;
import com.teste.civil.core.domain.aggregates.servidorTemporarios.ServidorTemporario;
import com.teste.civil.core.repository.pessoa.PessoaRepository;
import com.teste.civil.core.repository.pessoaendereco.PessoaEnderecoRepository;
import com.teste.civil.core.repository.servidorEfetivo.ServidorEfetivoRepository;
import com.teste.civil.core.repository.servidorTemporarios.ServidorTemporarioRepository;
import com.teste.civil.core.services.enderecos.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ServidorTemporarioRepository servidorTemporarioRepository;
    private final ServidorEfetivoRepository servidorEfetivoRepository;

    private final PessoaEnderecoRepository pessoaEnderecoRepository;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, ServidorTemporarioRepository servidorTemporarioRepository, ServidorEfetivoRepository servidorEfetivoRepository, PessoaEnderecoRepository pessoaEnderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.servidorTemporarioRepository = servidorTemporarioRepository;
        this.servidorEfetivoRepository = servidorEfetivoRepository;
        this.pessoaEnderecoRepository = pessoaEnderecoRepository;
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
        var endereco = createEndereco(pessoaDto.getEnderecoDto());
        createServidor(pessoaDto, Objects.requireNonNull(TypeServidor.fromInt(pessoaDto.getTypeServidor())), result.getId());
        pessoaEnderecoRepository.save(createPessoaEndereco(result.getId(),endereco.getEndId()));
        return result.getId();
    }

    private void createServidor(PessoaDto pessoaDto, TypeServidor typeServidor, Long id) {

        if (typeServidor.name().equalsIgnoreCase("Temporario")) {
            servidorTemporarioRepository.save(ServidorTemporario.create(id, pessoaDto.getServidorTemporarioDto().getStDataAdmissao(), pessoaDto.getServidorTemporarioDto().getStDataDemissao()));
        } else {
            servidorEfetivoRepository.save(ServidorEfetivo.create(id, pessoaDto.getServidorEfetivoDto().getSeMatricula()));
        }

    }
    private Endereco createEndereco(EnderecoDto enderecoDto){

        return enderecoService.save(enderecoDto);
    }
    private PessoaEndereco createPessoaEndereco(Long pesId,Long endId){
        return PessoaEndereco.create(pesId,endId);
    }

}

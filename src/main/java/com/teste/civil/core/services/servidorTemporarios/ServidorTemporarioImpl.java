package com.teste.civil.core.services.servidorTemporarios;

import com.teste.civil.core.domain.aggregates.servidorTemporarios.ServidorTemporario;
import com.teste.civil.core.repository.servidorTemporarios.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServidorTemporarioImpl implements ServidorTemporarioService {

    private ServidorTemporarioRepository servidorTemporarioRepository;

    @Autowired
    public ServidorTemporarioImpl(ServidorTemporarioRepository servidorTemporarioRepository) {
        this.servidorTemporarioRepository = servidorTemporarioRepository;
    }

    @Override
    public void create(Long pesId, String stDataAdmissao, String stDataDemissao) {
        var servidorTemporario = ServidorTemporario.create(pesId, LocalDateTime.parse(stDataAdmissao), LocalDateTime.parse(stDataDemissao));

        servidorTemporarioRepository.save(servidorTemporario);
    }
}

package com.teste.civil.core.domain.aggregates.servidorTemporarios;

import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "servidor_temporario")
@Getter
public class ServidorTemporario {

    @Column(name = "pes_id")
    @Id
    private Long pesId;
    @Column(name = "st_data_admissao")
    private LocalDateTime stDataAdmissao;
    @Column(name = "st_data_demissao")
    private LocalDateTime stDataDemissao;


    private ServidorTemporario(Long pesId, LocalDateTime stDataAdmissao, LocalDateTime stDataDemissao) {
        this.pesId = pesId;
        this.stDataAdmissao = stDataAdmissao;
        this.stDataDemissao = stDataDemissao;
    }

    public ServidorTemporario() {
    }

    public static ServidorTemporario create(Long pesId, LocalDateTime stDataAdmissao, LocalDateTime stDataDemissao) {

        var servidorTemporario = new ServidorTemporario(pesId, stDataAdmissao, stDataDemissao);
        CustomValidator.validateAndThrow(servidorTemporario);
        return servidorTemporario;

    }


}

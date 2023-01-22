package com.teste.civil.core.domain.aggregates.lotacoes;

import com.teste.civil.core.shared.Aggregate;
import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "lotacao")
@Getter
public class Lotacao implements Aggregate {

    @Id
    @Column(name = "lot_id")
    private Long lotId;
    @Column(name = "pes_id")
    private Long pesId;
    @Column(name = "unid_id")
    private Long unidId;
    @Column(name = "lot_data_lotacao")
    private LocalDateTime lotDataLotacao;
    @Column(name = "lot_data_remocao")
    private LocalDateTime lotDataRemocao;
    @Column(name = "lot_portaria")
    private String lotPortaria;

    private Lotacao(Long pesId, Long unidId, LocalDateTime lotDataLotacao, LocalDateTime lotDataRemocao, String lotPortaria) {
        this.pesId = pesId;
        this.unidId = unidId;
        this.lotDataLotacao = lotDataLotacao;
        this.lotDataRemocao = lotDataRemocao;
        this.lotPortaria = lotPortaria;
    }

    public static Lotacao create(Long pesId, Long unidId, LocalDateTime lotDataLotacao, LocalDateTime lotDataRemocao, String lotPortaria) {

        var lotacao = new Lotacao(pesId, unidId, lotDataLotacao, lotDataRemocao, lotPortaria);
        CustomValidator.validateAndThrow(lotacao);
        return lotacao;
    }

    @Override
    public Long getId() {
        return lotId;
    }
}

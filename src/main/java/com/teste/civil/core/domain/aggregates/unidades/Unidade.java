package com.teste.civil.core.domain.aggregates.unidades;

import com.teste.civil.core.shared.Aggregate;
import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "unidade")
@Getter
public class Unidade implements Aggregate {

    @Id
    @Column(name = "unid_id")
    private Long unidId;
    @Column(name = "unid_nome")
    private String unidNome;
    @Column(name = "unid_sigla")
    private String unidSigla;

    private Unidade(Long unidId, String unidNome, String unidSigla) {
        this.unidId = unidId;
        this.unidNome = unidNome;
        this.unidSigla = unidSigla;
    }

    public static Unidade create(Long unidId, String unidNome, String unidSigla) {

        var unidade = new Unidade(unidId, unidNome, unidSigla);
        CustomValidator.validateAndThrow(unidade);
        return unidade;
    }

    @Override
    public Long getId() {
        return unidId;
    }
}

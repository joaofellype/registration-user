package com.teste.civil.core.domain.aggregates.unidadeenderecos;

import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "unidade_endereco")
@Getter
public class UnidadeEndereco {

    @Column(name = "unid_id")
    @Id
    private Long unidId;
    @Column(name = "end_id")
    private Long endId;

    private UnidadeEndereco(Long unidId, Long endId) {
        this.unidId = unidId;
        this.endId = endId;
    }

    public static UnidadeEndereco create(Long unidId, Long endId){

        var unidadeEndereco = new UnidadeEndereco(unidId,endId);
        CustomValidator.validateAndThrow(unidadeEndereco);
        return unidadeEndereco;

    }


}

package com.teste.civil.core.domain.aggregates.pessoaenderecos;

import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "pessoa_endereco")
@Getter
public class PessoaEndereco {

    @Column(name = "pes_id")
    private Long pesId;
    @Column(name = "end_id")
    private Long endId;


    private PessoaEndereco(Long pesId, Long endId) {
        this.pesId = pesId;
        this.endId = endId;
    }

    public static PessoaEndereco create(Long pesId, Long endId){

        var pessoaEndereco = new PessoaEndereco(pesId,endId);
        CustomValidator.validateAndThrow(pessoaEndereco);
        return pessoaEndereco;
    }
}

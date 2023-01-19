package com.teste.civil.core.domain.aggregates.cidades;

import com.teste.civil.core.shared.Aggregate;
import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "cidade")
@Getter
public class Cidade implements Aggregate {
    @Column(name = "cid_id")
    @Id
    private Long cidId;
    @Column(name = "cid_nome")
    private String cidNome;
    @Column(name = "cid_uf")
    private String ciUf;


    private Cidade( String cidNome,String ciUf){
       this.cidNome = cidNome;
       this.ciUf = ciUf;
    }

    public static Cidade create(String cidNome,String ciUf){

        var cidade = new Cidade(cidNome,ciUf);
        CustomValidator.validateAndThrow(cidade);
        return cidade;
    }

    @Override
    public Long getId() {
        return cidId;
    }
}

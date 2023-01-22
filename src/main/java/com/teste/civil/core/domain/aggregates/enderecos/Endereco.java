package com.teste.civil.core.domain.aggregates.enderecos;

import com.teste.civil.core.shared.Aggregate;
import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "endereco")
@Getter
public class Endereco implements Aggregate {

    @Column(name = "end_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long endId;
    @Column(name = "end_tipo_logradouro")
    private String endTipoLogradouro;
    @Column(name = "end_logradouro")
    private String endLogradouro;
    @Column(name = "end_numero")
    private int endNumero;
    @Column(name = "end_bairro")
    private String bairro;
    @Column(name = "cid_id")
    private Long cidId;

    private Endereco(String endTipoLogradouro, String endLogradouro, int endNumero, String bairro, Long cidId) {
        this.endTipoLogradouro = endTipoLogradouro;
        this.endLogradouro = endLogradouro;
        this.endNumero = endNumero;
        this.bairro = bairro;
        this.cidId = cidId;
    }

    public static Endereco create(String endTipoLogradouro, String endLogradouro, int endNumero, String bairro, Long cidId) {

        var endereco = new Endereco(endTipoLogradouro, endLogradouro, endNumero, bairro, cidId);
        CustomValidator.validateAndThrow(endereco);
        return endereco;
    }

    @Override
    public Long getId() {
        return endId;
    }
}

package com.teste.civil.core.domain.aggregates.pessoa;

import com.teste.civil.core.shared.Aggregate;
import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Aggregate {
    @Column(name = "pes_nome")
    private final String pesNome;
    @Column(name = "pes_data_nascimento")
    private final LocalDateTime pesDataNascimento;
    @Column(name = "pes_sexo")
    private final String pesSexo;
    @Column(name = "pes_mae")
    private final String pesMae;
    @Column(name = "pes_pai")
    private final String pesPai;
    @Id
    @Column(name = "pes_id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long pesId;


    private Pessoa(String pesNome, LocalDateTime pesDataNascimento, String pesSexo, String pesMae, String pesPai) {

        this.pesNome = pesNome;
        this.pesDataNascimento = pesDataNascimento;
        this.pesSexo = pesSexo;
        this.pesMae = pesMae;
        this.pesPai = pesPai;
    }

    public static Pessoa create(String pesNome, LocalDateTime pesDataNascimento, String pesSexo, String pesMae, String pesPai) {

        var pessoa = new Pessoa(pesNome, pesDataNascimento, pesSexo, pesMae, pesPai);
        CustomValidator.validateAndThrow(pessoa);
        return pessoa;
    }

    public String getPesNome() {
        return pesNome;
    }

    public LocalDateTime getPesDataNascimento() {
        return pesDataNascimento;
    }

    public String getPesSexo() {
        return pesSexo;
    }

    public String getPesMae() {
        return pesMae;
    }

    public String getPesPai() {
        return pesPai;
    }

    @Override
    public Long getId() {
        return pesId;
    }
}

package com.teste.civil.core.domain.aggregates.servidorEfetivo;

import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servidor_efetivo")
@Getter
@NoArgsConstructor
public class ServidorEfetivo {
    @Id
    @Column(name = "pes_id")
    private Long pesId;
    @Column(name = "se_matricula")
    private String seMatricula;

    private ServidorEfetivo(Long pesId, String seMatricula) {
        this.pesId = pesId;
        this.seMatricula = seMatricula;

    }

    public static ServidorEfetivo create(Long pesId, String seMatricula) {

        var servidorEfetivo = new ServidorEfetivo(pesId, seMatricula);
        CustomValidator.validateAndThrow(servidorEfetivo);
        return servidorEfetivo;
    }
}

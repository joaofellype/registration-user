package com.teste.civil.core.domain.aggregates.fotoPessoa;

import com.teste.civil.core.shared.Aggregate;
import com.teste.civil.core.shared.validators.CustomValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "foto_pessoa")
public class FotoPessoa implements Aggregate {
    @Column(name = "pes_id")
    private Long pesId;
    @Id
    @Column(name = "fp_id")
    private Long fpId;
    @Column(name = "fp_data")
    private final LocalDateTime fpData;
    @Column(name = "fp_bucket")
    private final String fpBucket;
    @Column(name = "fp_hash")
    private final String fpHash;


    private FotoPessoa(Long pesId, LocalDateTime fpData, String fpBucket, String fpHash) {
        this.pesId = pesId;
        this.fpData = fpData;
        this.fpBucket = fpBucket;
        this.fpHash = fpHash;
    }

    public static FotoPessoa create(Long pesId, LocalDateTime fpData, String fpBucket, String fpHash) {
        var fotoPesso = new FotoPessoa(pesId, fpData, fpBucket, fpHash);
        CustomValidator.validateAndThrow(fotoPesso);
        return fotoPesso;
    }

    @Override
    public Long getId() {
        return fpId;
    }
}

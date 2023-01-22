package com.teste.civil.application.dto.fotoPessoas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FotoPessoaDto {

    private Long pesId;
    private LocalDateTime fpData;
    private String fpBucket;
    private String fpHash;
}

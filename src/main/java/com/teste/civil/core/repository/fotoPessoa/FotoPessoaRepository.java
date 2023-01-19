package com.teste.civil.core.repository.fotoPessoa;

import com.teste.civil.core.domain.aggregates.fotoPessoa.FotoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoPessoaRepository extends JpaRepository<FotoPessoa, Long> {
}

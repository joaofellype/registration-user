package com.teste.civil.core.repository.pessoa;

import com.teste.civil.core.domain.aggregates.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

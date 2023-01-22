package com.teste.civil.core.repository.pessoaendereco;

import com.teste.civil.core.domain.aggregates.pessoaenderecos.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
}

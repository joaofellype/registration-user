package com.teste.civil.core.repository.enderecos;

import com.teste.civil.core.domain.aggregates.enderecos.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

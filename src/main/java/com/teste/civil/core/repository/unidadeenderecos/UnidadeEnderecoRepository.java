package com.teste.civil.core.repository.unidadeenderecos;

import com.teste.civil.core.domain.aggregates.unidadeenderecos.UnidadeEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeEnderecoRepository extends JpaRepository<UnidadeEndereco,Long> {
}

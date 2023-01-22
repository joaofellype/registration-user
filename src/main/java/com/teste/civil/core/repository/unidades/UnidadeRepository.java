package com.teste.civil.core.repository.unidades;

import com.teste.civil.core.domain.aggregates.unidades.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
}

package com.teste.civil.core.repository.servidorEfetivo;

import com.teste.civil.core.domain.aggregates.servidorEfetivo.ServidorEfetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {


}

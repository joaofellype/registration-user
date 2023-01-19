package com.teste.civil.core.repository.servidorTemporarios;

import com.teste.civil.core.domain.aggregates.servidorTemporarios.ServidorTemporario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorTemporarioRepository extends JpaRepository<ServidorTemporario, Long> {
}

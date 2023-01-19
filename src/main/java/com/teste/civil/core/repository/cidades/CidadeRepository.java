package com.teste.civil.core.repository.cidades;

import com.teste.civil.core.domain.aggregates.cidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {

    List<Cidade> findByUf(String cid_uf);
}

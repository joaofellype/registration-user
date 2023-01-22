package com.teste.civil.core.repository.cidades;

import com.teste.civil.core.domain.aggregates.cidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByCidUf(String cid_uf);
}

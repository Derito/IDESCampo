package org.helderito.idescampo.domain.repository;

import org.helderito.idescampo.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}

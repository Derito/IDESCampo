package org.helderito.idescampo.domain.repository;

import org.helderito.idescampo.domain.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaisRepository extends JpaRepository<Pais,Long> {
}

package org.helderito.idescampo.domain.repository;


import java.util.List;

import org.helderito.idescampo.domain.model.Congregacao;
import org.helderito.idescampo.domain.model.Publicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublicadorRepository extends JpaRepository<Publicador,Long> {

	List<Publicador> findByCongregacao(Congregacao ccongregacao);

}


package org.helderito.idescampo.domain.repository;

import org.helderito.idescampo.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {
}

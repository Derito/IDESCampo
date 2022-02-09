package org.helderito.idescampo.domain.repository;

import org.helderito.idescampo.domain.model.Congregacao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CongregacaoRepository extends CustomJpaRepository<Congregacao,Long> {

    List<Congregacao> findTodasByNomeContaining(String nome);

    Optional<Congregacao> findByNome(String nome);

    boolean existsByNome(String nome);
}

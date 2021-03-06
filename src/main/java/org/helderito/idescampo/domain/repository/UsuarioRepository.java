package org.helderito.idescampo.domain.repository;

import org.helderito.idescampo.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
   Usuario findByNomeUsuario(String nomeUsuario);
}

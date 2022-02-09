package org.helderito.idescampo.infrastruture.repository.spec;

import org.helderito.idescampo.domain.model.Publicador;
import org.springframework.data.jpa.domain.Specification;

public class PublicadorSpecs {


    public static Specification<Publicador> comNomeSemelhante(String nome) {
        return (root, query, builder) ->
                builder.like(root.get("nome"), "%" + nome + "%");
    }

}

package org.helderito.idescampo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.helderito.idescampo.core.validation.Groups;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cidade extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	//@EqualsAndHashCode.Include
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nomeCid;

    @Valid
    @ConvertGroup(to = Groups.PaisId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais_id",nullable = false)
    private Pais pais;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cidade cidade = (Cidade) o;
        return id != null && Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
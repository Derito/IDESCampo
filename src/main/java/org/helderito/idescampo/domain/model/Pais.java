package org.helderito.idescampo.domain.model;

import lombok.*;
import org.helderito.idescampo.core.validation.Groups;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pais extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	//@NotNull(groups = Groups.PaisId.class)
   // @EqualsAndHashCode.Include
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 60)
    private String nomePais;

}

package org.helderito.idescampo.domain.model;

import lombok.*;
import org.helderito.idescampo.core.validation.Groups;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
    @ConvertGroup(from = Default.class, to = Groups.PaisId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais_id",nullable = false)
    private Pais pais;

}
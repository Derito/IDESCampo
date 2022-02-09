package org.helderito.idescampo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.helderito.idescampo.core.validation.Groups;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Congregacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull(groups = Groups.CongregacaoId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank
    @Column(name = "nome", nullable = false)
    private  String nome;

    @NotBlank
    @Column(nullable = false)
    private int numCong;

    private Boolean activo;

    @NotBlank
    @Embedded
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "congregacao")
    private List<Publicador> publicadores = new ArrayList<>();

}

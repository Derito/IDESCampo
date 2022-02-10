package org.helderito.idescampo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Usuario extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    @NotEmpty
    @Column(nullable=false)
    private String nome;

	@Column(nullable = false, unique = true)
    @NotEmpty
    private String nomeUsuario;  

    @Column(nullable = false)
    @JsonIgnore
    private String senha;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime dataCadastro;

    @OneToOne
    private Publicador publicador;

    @ManyToMany
    @JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private List<Grupo> grupos = new ArrayList<>();

    @NotEmpty
    public boolean admin;

}

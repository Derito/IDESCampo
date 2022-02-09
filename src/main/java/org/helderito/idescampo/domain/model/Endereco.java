package org.helderito.idescampo.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank
    @Column(name = "endereco_municipio")
    private String municipio;

	@NotBlank
    @Column(name = "endereco_numero")
    private String numero;

	@NotBlank
    @Column(name = "endereco_rua")
    private String rua;

	@NotBlank
    @Column(name = "endereco_bairro")
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;

}

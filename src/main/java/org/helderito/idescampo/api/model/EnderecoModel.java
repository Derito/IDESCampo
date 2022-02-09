package org.helderito.idescampo.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {

	private String municipio;
    private String numero;
    private String rua;
    private String bairro;
    private CidadeModel cidade;
}

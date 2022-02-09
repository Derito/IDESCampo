package org.helderito.idescampo.api.model;

import java.time.OffsetDateTime;

import org.helderito.idescampo.domain.model.StatusPublicador;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicadorModel {
	 
    private OffsetDateTime dataDesignacao;   
	private StatusPublicador status;
    private EnderecoModel endereco;    
    private CongregacaoModel congregacao;
    private UsuarioModel usuario;
    
    
    
}

package org.helderito.idescampo.api.model.input;

import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicadorInputModel {

	   
	    @NotNull
	    private OffsetDateTime dataDesignacao;   	    
	   	    
	    @Valid
		@NotNull
	    private CongregacaoInputModel congregacao;
	    
	    @Valid
		@NotNull
	    private UsuarioInputModel usuario;
}

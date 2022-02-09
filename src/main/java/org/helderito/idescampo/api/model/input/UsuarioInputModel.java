package org.helderito.idescampo.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInputModel {
	
	@NotNull
	private long id;
	

}

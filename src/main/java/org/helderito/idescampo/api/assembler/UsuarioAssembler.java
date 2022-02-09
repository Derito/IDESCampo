package org.helderito.idescampo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.helderito.idescampo.api.model.UsuarioModel;
import org.helderito.idescampo.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UsuarioAssembler {

private ModelMapper modelMapper;
	
	public UsuarioModel toModel(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioModel.class);
	}
 
	public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios){
		return usuarios.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}

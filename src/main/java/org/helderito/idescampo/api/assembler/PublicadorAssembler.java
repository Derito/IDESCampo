package org.helderito.idescampo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.helderito.idescampo.api.model.PublicadorModel;
import org.helderito.idescampo.api.model.input.PublicadorInputModel;
import org.helderito.idescampo.domain.model.Publicador;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PublicadorAssembler {

private ModelMapper modelMapper;
	
	public PublicadorModel toModel(Publicador publicador) {
		return modelMapper.map(publicador,PublicadorModel.class);
	}
	public List<PublicadorModel> toCollectionModel(List<Publicador> publicadores){
		return publicadores.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

	public Publicador toEntity(PublicadorInputModel publicadorInputModel) {
		return modelMapper.map(publicadorInputModel, Publicador.class);
		
	}
}

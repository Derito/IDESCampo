package org.helderito.idescampo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.helderito.idescampo.api.model.RelatorioModel;
import org.helderito.idescampo.domain.model.Relatorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RelatorioAssembler {

private ModelMapper modelMapper;
	
	public RelatorioModel toModel(Relatorio relatorio) {
		return modelMapper.map(relatorio, RelatorioModel.class);
	}
 
	public List<RelatorioModel> toCollectionModel(List<Relatorio> relatorios){
		return relatorios.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}

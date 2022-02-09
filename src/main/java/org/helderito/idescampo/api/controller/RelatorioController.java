package org.helderito.idescampo.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.helderito.idescampo.api.assembler.RelatorioAssembler;
import org.helderito.idescampo.api.model.RelatorioModel;
import org.helderito.idescampo.api.model.input.RelatorioInputModel;
import org.helderito.idescampo.domain.model.Publicador;
import org.helderito.idescampo.domain.model.Relatorio;
import org.helderito.idescampo.domain.service.BuscaPublicadorService;
import org.helderito.idescampo.domain.service.RelatorioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/publicadores/{publicadorId}/relatorios")
public class RelatorioController {

	private BuscaPublicadorService buscaPublicadorService;
	private RelatorioService relatorioService;
	private RelatorioAssembler relatorioAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RelatorioModel registrar(@PathVariable Long publicadorId, 
			@Valid @RequestBody RelatorioInputModel relatorioInputModel) {
		
		Relatorio relatorioRegistrada = relatorioService.registrar(publicadorId,relatorioInputModel.getClass());
		
		return relatorioAssembler.toModel(relatorioRegistrada);
	}
	
	@GetMapping
	public List<RelatorioModel> listar(@PathVariable Long publicadorId){
		Publicador publicador = buscaPublicadorService.buscar(publicadorId);
		
		return relatorioAssembler.toCollectionModel(publicador.getRelatorios());
	}
}

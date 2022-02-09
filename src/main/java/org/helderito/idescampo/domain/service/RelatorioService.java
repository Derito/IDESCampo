package org.helderito.idescampo.domain.service;

import javax.validation.Valid;

import org.helderito.idescampo.api.model.input.RelatorioInputModel;
import org.helderito.idescampo.domain.model.Publicador;
import org.helderito.idescampo.domain.model.Relatorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RelatorioService {

	/*
	 * Chama a classe que contêm o metodo buscar por id
	 */
	private BuscaPublicadorService buscaPublicadorService;
	
	@Transactional
	public Relatorio registrar(Long publicadorId , Class<? extends @Valid 
			RelatorioInputModel> class1) {
		
		Publicador publicador = buscaPublicadorService.buscar(publicadorId);
		
		return publicador.adicionarRelatorio();
	}
}

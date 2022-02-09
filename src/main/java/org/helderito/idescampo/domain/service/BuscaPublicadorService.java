package org.helderito.idescampo.domain.service;

import org.helderito.idescampo.domain.exception.EntidadeNaoEncontradaException;
import org.helderito.idescampo.domain.model.Publicador;
import org.helderito.idescampo.domain.repository.PublicadorRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaPublicadorService {

	private PublicadorRepository publicadorRepository;
	/*
	 * Sendo um metodo muito usado, achou-se por bem ser inserido em uma classe a parte.
	 */
	public Publicador buscar(Long publicadorId) {
	
		return publicadorRepository.findById(publicadorId)
			.orElseThrow(()-> new EntidadeNaoEncontradaException("Publicador não encontrado!"));
	}
}

package org.helderito.idescampo.domain.service;

import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.helderito.idescampo.domain.model.Congregacao;
import org.helderito.idescampo.domain.model.Publicador;
import org.helderito.idescampo.domain.model.StatusPublicador;
import org.helderito.idescampo.domain.repository.PublicadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PublicadorService {
	
	private PublicadorRepository publicadorRepository;
	private CongregacaoService congregacaoService;

	
	public List<Publicador> listar(){
		return (publicadorRepository.findAll());
	}
	
	public Optional<Publicador> buscar(Long usuarioId) {		
		return publicadorRepository.findById(usuarioId);				
	}
	
	@Transactional
	public Publicador salvar(Publicador publicador) {
	 Congregacao congregacao = congregacaoService.buscarOuFalhar(publicador.getCongregacao().getId());
		
	 	publicador.setCongregacao(congregacao);
	 	publicador.setStatus(StatusPublicador.ACTIVO);
	 	publicador.setDataDesignacao(OffsetDateTime.now());
	 	//publicador.setUsuarios(publicador.getUsuarios());
	 	publicador.setRelatorios(publicador.getRelatorios());
		
		
		return publicadorRepository.save(publicador);
	}

}

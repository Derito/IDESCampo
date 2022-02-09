package org.helderito.idescampo.domain.service;

import lombok.AllArgsConstructor;
import org.helderito.idescampo.domain.exception.CongregacaoNaoEncontradoException;
import org.helderito.idescampo.domain.model.Congregacao;
import org.helderito.idescampo.domain.repository.CongregacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class CongregacaoService {

       private CongregacaoRepository congregacaoRepository;
   
	@Transactional
	public Congregacao salvar(Congregacao congregacao) {
		
		return congregacaoRepository.save(congregacao);
	}
	@Transactional
	public void excluir(Long congregacaoId) {
		 congregacaoRepository.deleteById(congregacaoId);
	}

        public Congregacao buscarOuFalhar(Long congregacaoId) {
            return congregacaoRepository.findById(congregacaoId)
                    .orElseThrow(() -> new CongregacaoNaoEncontradoException(congregacaoId));
        }
}

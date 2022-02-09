package org.helderito.idescampo.domain.service;

import lombok.AllArgsConstructor;
import org.helderito.idescampo.domain.exception.EntidadeEmUsoException;
import org.helderito.idescampo.domain.exception.PaisNaoEncontradoException;
import org.helderito.idescampo.domain.model.Pais;
import org.helderito.idescampo.domain.repository.PaisRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PaisService {


    private static final String MSG_PAIS_EM_USO
            = "Pais de código %d não pode ser removido, pois está em uso";
    
    private PaisRepository paisRepository;

    public Pais buscarOuFalhar(Long paisId) {
        return paisRepository.findById(paisId)
                .orElseThrow(() -> new PaisNaoEncontradoException(paisId));
    }

    @Transactional
    public Pais salvar(Pais pais) {
        return paisRepository.save(pais);
    }

    @Transactional
    public void excluir(Long paisId) {
        try {
            paisRepository.deleteById(paisId);

        } catch (EmptyResultDataAccessException e) {
            throw new PaisNaoEncontradoException(paisId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_PAIS_EM_USO, paisId));
        }
    }
}

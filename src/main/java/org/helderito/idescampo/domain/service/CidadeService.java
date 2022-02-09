package org.helderito.idescampo.domain.service;

import lombok.AllArgsConstructor;
import org.helderito.idescampo.domain.exception.CidadeNaoEncontradaException;
import org.helderito.idescampo.domain.exception.EntidadeEmUsoException;
import org.helderito.idescampo.domain.model.Cidade;
import org.helderito.idescampo.domain.model.Pais;
import org.helderito.idescampo.domain.repository.CidadeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CidadeService {

    private static final String MSG_CIDADE_EM_USO
            = "Cidade de código %d não pode ser removida, pois está em uso";
  //  @Autowired  retirado substituido pelo construtor
    private CidadeRepository cidadeRepository;


    private PaisService paisService;

    @Transactional
    public Cidade salvar(Cidade cidade) {

        Long paisId = cidade.getPais().getId();
        Pais pais = paisService.buscarOuFalhar(paisId);
        cidade.setPais(pais);
        return cidadeRepository.save(cidade);
    }
    @Transactional
    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new CidadeNaoEncontradaException(cidadeId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_CIDADE_EM_USO, cidadeId));
        }
    }

    public Cidade buscarOuFalhar(Long cidadeId) {
        return cidadeRepository.findById(cidadeId)
                .orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId));
    }
}

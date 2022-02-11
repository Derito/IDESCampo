package org.helderito.idescampo.api.controller;


import org.helderito.idescampo.domain.exception.NegocioException;
import org.helderito.idescampo.domain.exception.PaisNaoEncontradoException;
import org.helderito.idescampo.domain.model.Cidade;
import org.helderito.idescampo.domain.repository.CidadeRepository;
import org.helderito.idescampo.domain.service.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "v3")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "protected/cidades")
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }

    @GetMapping("protected/cidades/{cidadeId}")
    public Cidade buscar(@PathVariable Long cidadeId) {
        return cidadeService.buscarOuFalhar(cidadeId);
    }

    @PostMapping(path = "admin/cidades")
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody @Valid Cidade cidade) {
        try {
            return cidadeService.salvar(cidade);
        } catch (PaisNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("admin/cidades/{cidadeId}")
    public Cidade atualizar(@PathVariable Long cidadeId,@RequestBody @Valid Cidade cidade) {
        try {
            Cidade cidadeAtual = cidadeService.buscarOuFalhar(cidadeId);
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");
            return cidadeService.salvar(cidadeAtual);
        } catch (PaisNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("admin/cidades/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
                 cidadeService.excluir(cidadeId);
    }
}

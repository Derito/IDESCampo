package org.helderito.idescampo.api.controller;

import org.helderito.idescampo.domain.model.Congregacao;
import org.helderito.idescampo.domain.repository.CongregacaoRepository;
import org.helderito.idescampo.domain.service.CongregacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/congregacoes")
public class CongregacaoController {

    @Autowired
    private CongregacaoRepository congregacaoRepository;

    @Autowired
    private CongregacaoService congregacaoService;

    @GetMapping
    public List<Congregacao> listar() {
        return congregacaoRepository.findAll();
    }

    @GetMapping("/{congregacaoId}")
    public Congregacao buscar(@PathVariable Long congregacaoId) {
        return congregacaoService.buscarOuFalhar(congregacaoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Congregacao adicionar(@RequestBody @Valid Congregacao congregacao) {
        return congregacaoService.salvar(congregacao);
    }

    @PutMapping("/{congregacaoId}")
    public Congregacao atualizar(@PathVariable Long congregacaoId,
                                             @RequestBody @Valid Congregacao congregacao) {
        Congregacao congAtual = congregacaoService.buscarOuFalhar(congregacaoId);

        BeanUtils.copyProperties(congregacao, congAtual, "id");

        return congregacaoService.salvar(congAtual);
        }

    @DeleteMapping("/{congregacaoId}")
    public void remover(@PathVariable Long congregacaoId) {
                  congregacaoService.excluir(congregacaoId);
    }
}

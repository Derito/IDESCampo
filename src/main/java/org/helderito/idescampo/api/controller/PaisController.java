package org.helderito.idescampo.api.controller;

import org.helderito.idescampo.domain.model.Pais;
import org.helderito.idescampo.domain.repository.PaisRepository;
import org.helderito.idescampo.domain.service.PaisService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private PaisService paisService;

    @GetMapping(path = "protected/paises")
    public ResponseEntity<?> listar() {
        return new ResponseEntity(paisRepository.findAll(),HttpStatus.FOUND);
    }

    @GetMapping("protected/paises/{paisId}")
    public ResponseEntity<?> buscar(@PathVariable Long paisId) {
        return new ResponseEntity(paisService.buscarOuFalhar(paisId),HttpStatus.FOUND);
    }

    @PostMapping(path = "protected/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais adicionar(@RequestBody @Valid Pais pais) {
        return paisService.salvar(pais);
    }

    @PutMapping("protected/paises/{paisId}")
    public Pais atualizar(@PathVariable Long paisId,
                                            @RequestBody @Valid Pais pais) {
        Pais paisActual = paisService.buscarOuFalhar(paisId);
        BeanUtils.copyProperties(pais, paisActual, "id");
        return paisService.salvar(paisActual);
        }

    @DeleteMapping("protected/paises/{paisId}")
    public void remover(@PathVariable Long paisId) {
            paisService.excluir(paisId);
    }
}

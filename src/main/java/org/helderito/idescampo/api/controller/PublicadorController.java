package org.helderito.idescampo.api.controller;

import org.helderito.idescampo.api.assembler.PublicadorAssembler;
import org.helderito.idescampo.api.model.PublicadorModel;
import org.helderito.idescampo.api.model.input.PublicadorInputModel;
import org.helderito.idescampo.domain.model.Publicador;
import org.helderito.idescampo.domain.service.PublicadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/publicadores")
public class PublicadorController {
   
    private PublicadorAssembler publicadorAssembler;
    
    private PublicadorService publicadorService;

    @GetMapping
    public List<PublicadorModel> listar() {
    	return publicadorAssembler.toCollectionModel(publicadorService.listar());
    }

    @GetMapping("/{Id}")
	public ResponseEntity<PublicadorModel> buscar(@PathVariable Long publicadorId) {		
		return publicadorService.buscar(publicadorId)
				.map(publicador -> ResponseEntity.ok(publicadorAssembler.toModel(publicador)))
				.orElse(ResponseEntity.notFound().build());
	}  
   
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicadorModel adicionar(@Valid @RequestBody PublicadorInputModel publicadorInputModel) {
        Publicador novoPub = publicadorAssembler.toEntity(publicadorInputModel);
        Publicador publicadorSol = publicadorService.salvar(novoPub);
    	
        return publicadorAssembler.toModel(publicadorSol);
    }

//    @PutMapping("/{publicadorId}")
//    public Publicador atualizar(@PathVariable Long publicadorId,
//                            @RequestBody Publicador publicador) {
//        try {
//            Publicador pubAtual = publicadorService.buscarOuFalhar(publicadorId);
//
//            BeanUtils.copyProperties(publicador, pubAtual, "id");
//
//            return publicadorService.salvar(pubAtual);
//        } catch (CongregacaoNaoEncontradoException e) {
//            throw new NegocioException(e.getMessage(), e);
//        }
//    }
//
//    @DeleteMapping("/{cidadeId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void remover(@PathVariable Long publicadorId) {
//        publicadorService.excluir(publicadorId);
//    }
}

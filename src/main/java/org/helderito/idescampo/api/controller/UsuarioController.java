package org.helderito.idescampo.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.helderito.idescampo.api.assembler.UsuarioAssembler;
import org.helderito.idescampo.api.model.UsuarioModel;
import org.helderito.idescampo.api.model.input.UsuarioInputModel;
import org.helderito.idescampo.domain.model.Publicador;
import org.helderito.idescampo.domain.model.Usuario;
import org.helderito.idescampo.domain.service.BuscaPublicadorService;
import org.helderito.idescampo.domain.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/publicadores/{publicadorId}/usuarios")
public class UsuarioController {
	
	private UsuarioAssembler usuarioAssembler;
	private BuscaPublicadorService buscaPublicadorService;	
	private UsuarioService usuarioService;	
//	    
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public UsuarioModel salvar(@PathVariable Long publicadorId, 
//			@Valid @RequestBody UsuarioInputModel usuarioInputModel) {
//		
//		Usuario usuarioRegistrada = usuarioService.registrar(publicadorId,usuarioInputModel.getClass());
//		
//		return usuarioAssembler.toModel(usuarioRegistrada);
//	}
	
//	@GetMapping
//	public List<UsuarioModel> listar(@PathVariable Long publicadorId){
//		Publicador publicador = buscaPublicadorService.buscar(publicadorId);
//		
//		return usuarioAssembler.toCollectionModel(publicador.getUsuarios());
//	}
}

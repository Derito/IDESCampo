package org.helderito.idescampo.domain.exception;

public class PaisNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public PaisNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public PaisNaoEncontradoException(Long paisId) {
        this(String.format("Não existe um cadastro de pais com código %d", paisId));
    }

}

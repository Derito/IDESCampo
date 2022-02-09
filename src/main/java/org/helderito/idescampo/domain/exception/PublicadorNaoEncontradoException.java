package org.helderito.idescampo.domain.exception;

public class PublicadorNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public PublicadorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public PublicadorNaoEncontradoException(Long publicadorId) {
        this(String.format("Não existe um cadastro de publicador com código %d", publicadorId));
    }
}

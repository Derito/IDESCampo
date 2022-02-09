package org.helderito.idescampo.domain.exception;

public class CongregacaoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public CongregacaoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CongregacaoNaoEncontradoException(Long congId) {
        this(String.format("Não existe um cadastro de congregacao com código %d", congId));
    }

}

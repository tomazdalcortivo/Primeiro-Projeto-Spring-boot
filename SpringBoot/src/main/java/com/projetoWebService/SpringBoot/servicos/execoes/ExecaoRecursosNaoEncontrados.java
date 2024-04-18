package com.projetoWebService.SpringBoot.servicos.execoes;

public class ExecaoRecursosNaoEncontrados extends RuntimeException{

    public ExecaoRecursosNaoEncontrados(Object id){
        super("recurso não encontrado. id "+ id);
    }
}

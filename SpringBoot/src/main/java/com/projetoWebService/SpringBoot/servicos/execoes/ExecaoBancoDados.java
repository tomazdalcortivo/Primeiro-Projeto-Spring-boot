package com.projetoWebService.SpringBoot.servicos.execoes;

public class ExecaoBancoDados extends  RuntimeException{
    public ExecaoBancoDados(String msg ){
        super(msg);
    }
}

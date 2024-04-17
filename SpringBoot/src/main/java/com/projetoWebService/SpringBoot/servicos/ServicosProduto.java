package com.projetoWebService.SpringBoot.servicos;

import com.projetoWebService.SpringBoot.entidades.Produto;
import com.projetoWebService.SpringBoot.entidades.Usuario;
import com.projetoWebService.SpringBoot.repositorios.RepositorioProduto;
import com.projetoWebService.SpringBoot.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component
@Service
public class ServicosProduto {

    @Autowired
    private RepositorioProduto repositorio;


    public List<Produto> findAll() {
        return repositorio.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repositorio.findById(id);
        return obj.get();
    }
}

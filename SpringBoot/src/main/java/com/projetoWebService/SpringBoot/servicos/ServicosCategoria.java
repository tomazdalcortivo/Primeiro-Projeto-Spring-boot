package com.projetoWebService.SpringBoot.servicos;

import com.projetoWebService.SpringBoot.entidades.Categoria;
import com.projetoWebService.SpringBoot.repositorios.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosCategoria {

    @Autowired
    private RepositorioCategoria repositorio;


    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repositorio.findById(id);
        return obj.get();
    }
}

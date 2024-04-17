package com.projetoWebService.SpringBoot.servicos;

import com.projetoWebService.SpringBoot.entidades.Pedido;
import com.projetoWebService.SpringBoot.repositorios.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component
@Service
public class ServicosPedido {

    @Autowired
    private RepositorioPedido repositorio;


    public List<Pedido> findAll() {
        return repositorio.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repositorio.findById(id);
        return obj.get();
    }
}

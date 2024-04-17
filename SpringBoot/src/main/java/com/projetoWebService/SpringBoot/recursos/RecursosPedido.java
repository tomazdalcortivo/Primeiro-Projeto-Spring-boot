package com.projetoWebService.SpringBoot.recursos;

import com.projetoWebService.SpringBoot.entidades.Pedido;
import com.projetoWebService.SpringBoot.servicos.ServicosPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  "/pedido")
public class RecursosPedido {

    @Autowired
    private ServicosPedido servico;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

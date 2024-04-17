package com.projetoWebService.SpringBoot.recursos;

import com.projetoWebService.SpringBoot.entidades.Categoria;
import com.projetoWebService.SpringBoot.entidades.Pedido;
import com.projetoWebService.SpringBoot.servicos.ServicosCategoria;
import com.projetoWebService.SpringBoot.servicos.ServicosPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  "/categoria")
public class RecursosCategoria {

    @Autowired
    private ServicosCategoria servico;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

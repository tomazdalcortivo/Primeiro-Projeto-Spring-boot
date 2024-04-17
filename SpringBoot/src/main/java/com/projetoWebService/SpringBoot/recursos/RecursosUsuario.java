package com.projetoWebService.SpringBoot.recursos;

import com.projetoWebService.SpringBoot.entidades.Usuario;
import com.projetoWebService.SpringBoot.servicos.ServicosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  "/usuario")
public class RecursosUsuario {

    @Autowired
    private ServicosUsuario servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

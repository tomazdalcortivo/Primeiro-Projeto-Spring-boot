package com.projetoWebService.SpringBoot.recursos;

import com.projetoWebService.SpringBoot.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/usuario")
public class RecursosUsuario {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario( 1L, "maria", "maria@gmail","1234", "8888888");
        return ResponseEntity.ok().body(u);
    }

}

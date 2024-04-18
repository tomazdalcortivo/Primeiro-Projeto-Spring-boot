package com.projetoWebService.SpringBoot.recursos;

import com.projetoWebService.SpringBoot.entidades.Usuario;
import com.projetoWebService.SpringBoot.servicos.ServicosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class RecursosUsuario {

    @Autowired
    private ServicosUsuario servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) {
        obj = servico.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servico.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.projetoWebService.SpringBoot.servicos;

import com.projetoWebService.SpringBoot.entidades.Usuario;
import com.projetoWebService.SpringBoot.repositorios.RepositorioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
@Service
public class ServicosUsuario {

    @Autowired
    private RepositorioUsuario repositorio;


    public List<Usuario> findAll() {
        return repositorio.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repositorio.findById(id);
        return obj.get();
    }

    public Usuario insert(Usuario obj){
        return repositorio.save(obj);
    }

    public void delete(Long id ){
        repositorio.deleteById(id);
    }

    public Usuario update(long id, Usuario obj){
        Usuario entidade = repositorio.getReferenceById(id);
        updateData(entidade, obj);
        return repositorio.save(entidade);
    }

    private void updateData(Usuario entidade, Usuario obj) {
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());
    }
}

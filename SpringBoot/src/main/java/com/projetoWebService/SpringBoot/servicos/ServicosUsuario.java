package com.projetoWebService.SpringBoot.servicos;

import com.projetoWebService.SpringBoot.entidades.Usuario;
import com.projetoWebService.SpringBoot.repositorios.RepositorioUsuario;

import com.projetoWebService.SpringBoot.servicos.execoes.ExecaoBancoDados;
import com.projetoWebService.SpringBoot.servicos.execoes.ExecaoRecursosNaoEncontrados;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ExecaoRecursosNaoEncontrados(id));
    }

    public Usuario insert(Usuario obj) {
        return repositorio.save(obj);
    }

    public void delete(Long id) {
        try {
            repositorio.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ExecaoRecursosNaoEncontrados(id);
        } catch (DataIntegrityViolationException e) {
            throw new ExecaoBancoDados(e.getMessage());
        }
    }

    public Usuario update(long id, Usuario obj) {
        try {
            Usuario entidade = repositorio.getReferenceById(id);
            updateData(entidade, obj);
            return repositorio.save(entidade);
        } catch (EntityNotFoundException e){
            throw new ExecaoRecursosNaoEncontrados(id);
        }
    }

    private void updateData(Usuario entidade, Usuario obj) {
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());
    }
}

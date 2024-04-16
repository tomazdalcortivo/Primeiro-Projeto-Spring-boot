package com.projetoWebService.SpringBoot.repositorios;

import com.projetoWebService.SpringBoot.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

}

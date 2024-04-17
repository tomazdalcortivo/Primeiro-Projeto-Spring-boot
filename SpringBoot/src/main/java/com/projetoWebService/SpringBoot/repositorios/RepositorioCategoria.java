package com.projetoWebService.SpringBoot.repositorios;

import com.projetoWebService.SpringBoot.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long>{

}

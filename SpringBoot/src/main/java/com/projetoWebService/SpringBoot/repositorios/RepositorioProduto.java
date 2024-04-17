package com.projetoWebService.SpringBoot.repositorios;

import com.projetoWebService.SpringBoot.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProduto extends JpaRepository<Produto, Long>{

}

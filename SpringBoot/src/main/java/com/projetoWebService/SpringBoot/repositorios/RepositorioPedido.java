package com.projetoWebService.SpringBoot.repositorios;

import com.projetoWebService.SpringBoot.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPedido extends JpaRepository<Pedido, Long>{

}

package com.projetoWebService.SpringBoot.repositorios;

import com.projetoWebService.SpringBoot.entidades.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, Long>{

}

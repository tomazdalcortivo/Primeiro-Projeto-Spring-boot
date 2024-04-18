package com.projetoWebService.SpringBoot.config;

import com.projetoWebService.SpringBoot.entidades.*;
import com.projetoWebService.SpringBoot.entidades.enums.StatusPedido;
import com.projetoWebService.SpringBoot.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioPedido repositorioPedido;

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Autowired
    private RepositorioProduto repositorioProduto;

    @Autowired
    private RepositorioItemPedido repositorioItemPedido;


    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Electronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto pr1 = new Produto(null, "senhor dos aneis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto pr5 = new Produto(null, "Neuromancer", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
        repositorioProduto.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        pr1.getCategorias().add(cat2);
        pr2.getCategorias().add(cat1);
        pr2.getCategorias().add(cat3);
        pr3.getCategorias().add(cat3);
        pr4.getCategorias().add(cat3);
        pr5.getCategorias().add(cat2);

        repositorioProduto.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        repositorioUsuario.saveAll(Arrays.asList(u1, u2));

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);

        repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));

        ItemPedido ip1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
        ItemPedido ip2 = new ItemPedido(p1, pr3, 1, pr4.getPreco());
        ItemPedido ip3 = new ItemPedido(p2, pr3, 2, pr1.getPreco());
        ItemPedido ip4 = new ItemPedido(p3, pr5, 2, pr5.getPreco());

        repositorioItemPedido.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));

        Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), p1);
        p1.setPagamento(pag1);

        repositorioPedido.save(p1);
    }
}

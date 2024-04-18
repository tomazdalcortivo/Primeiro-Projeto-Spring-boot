package com.projetoWebService.SpringBoot.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoWebService.SpringBoot.entidades.enums.StatusPedido;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer statusPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> items = new HashSet<>();

    @OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido() {
    }

    public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
        this.cliente = cliente;
        this.id = id;
        setStatusPedido(statusPedido);
        this.momento = momento;
    }

    public Set<ItemPedido> getItems() {
        return items;
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if (statusPedido != null) this.statusPedido = statusPedido.getCodigo();
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

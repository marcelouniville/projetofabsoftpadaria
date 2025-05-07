package br.univille.projfabsoftpadaria.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime horarioRetirada;

    @ManyToMany
    @JoinTable(
        name = "pedido_produto", 
        joinColumns = @JoinColumn(name = "pedido_id"), 
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    // Construtores
    public Pedido() {}

    public Pedido(long id, List<Produto> produtos, LocalDateTime horarioRetirada) {
        this.id = id;
        this.produtos = produtos;
        this.horarioRetirada = horarioRetirada;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getHorarioRetirada() {
        return horarioRetirada;
    }

    public void setHorarioRetirada(LocalDateTime horarioRetirada) {
        this.horarioRetirada = horarioRetirada;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}



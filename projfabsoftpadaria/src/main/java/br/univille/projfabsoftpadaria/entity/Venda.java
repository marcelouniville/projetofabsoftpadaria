package br.univille.projfabsoftpadaria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate data;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;

    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    private RelatorioDiario relatorioDiario;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public RelatorioDiario getRelatorioDiario() {
        return relatorioDiario;
    }

    public void setRelatorioDiario(RelatorioDiario relatorioDiario) {
        this.relatorioDiario = relatorioDiario;
    }
}




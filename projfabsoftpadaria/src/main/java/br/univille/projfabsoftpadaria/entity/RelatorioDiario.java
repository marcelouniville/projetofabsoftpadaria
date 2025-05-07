package br.univille.projfabsoftpadaria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class RelatorioDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate data;
    private Integer quantidadeVendida;
    private Double lucro;

    @OneToMany(mappedBy = "relatorioDiario", cascade = CascadeType.ALL)
    private List<Venda> vendas;

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

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    // Método para calcular resumo com base nas vendas
    public void calcularResumo() {
        int totalQuantidade = 0;
        double totalLucro = 0.0;

        if (vendas != null) {
            for (Venda venda : vendas) {
                if (venda.getItens() != null) {
                    for (ItemVenda item : venda.getItens()) {
                        totalQuantidade += item.getQuantidade();
                        totalLucro += item.getQuantidade() * item.getProduto().getPreco();
                    }
                }
            }
        }

        this.quantidadeVendida = totalQuantidade;
        this.lucro = totalLucro;
    }
}

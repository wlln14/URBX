package com.URBX.URBX.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeProdutoURBX;

    @Column(nullable = false)
    private BigDecimal precoProdutoURBX;

    @Column(nullable = false)
    private String tipoProdutoURBX;

    @Column(nullable = false)
    private String tamanhoProdutoURBX;

    @Column(nullable = false)
    private String corProdutoURBX;

    public Produto() {

    }

    public Produto(String nomeProdutoURBX, BigDecimal precoProdutoURBX, String tipoProdutoURBX, String tamanhoProdutoURBX, String corProdutoURBX) {
        this.nomeProdutoURBX = nomeProdutoURBX;
        this.precoProdutoURBX = precoProdutoURBX;
        this.tipoProdutoURBX = tipoProdutoURBX;
        this.tamanhoProdutoURBX = tamanhoProdutoURBX;
        this.corProdutoURBX = corProdutoURBX;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProdutoURBX() {
        return nomeProdutoURBX;
    }

    public void setNomeProdutoURBX(String nomeProdutoURBX) {
        this.nomeProdutoURBX = nomeProdutoURBX;
    }

    public BigDecimal getPrecoProdutoURBX() {
        return precoProdutoURBX;
    }

    public void setPrecoProdutoURBX(BigDecimal precoProdutoURBX) {
        this.precoProdutoURBX = precoProdutoURBX;
    }

    public String getTipoProdutoURBX() {
        return tipoProdutoURBX;
    }

    public void setTipoProdutoURBX(String tipoProdutoURBX) {
        this.tipoProdutoURBX = tipoProdutoURBX;
    }

    public String getTamanhoProdutoURBX() {
        return tamanhoProdutoURBX;
    }

    public void setTamanhoProdutoURBX(String tamanhoProdutoURBX) {
        this.tamanhoProdutoURBX = tamanhoProdutoURBX;
    }

    public String getCorProdutoURBX() {
        return corProdutoURBX;
    }

    public void setCorProdutoURBX(String corProdutoURBX) {
        this.corProdutoURBX = corProdutoURBX;
    }
}

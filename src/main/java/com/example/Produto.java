package com.example;

public record Produto(String descricao, Double preco) {
    @Override
    public String toString() {
        return descricao + " -  R$" + preco;
    }
}

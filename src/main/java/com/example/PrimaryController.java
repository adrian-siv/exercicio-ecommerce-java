package com.example;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    Button botao1;
    @FXML
    Button botao2;
    @FXML
    Button botao3;
    @FXML
    Button botao4;
    @FXML
    ListView<Produto> listProdutos;
    @FXML
    Text numeroProdutos;

    private ArrayList<Produto> produtos = new ArrayList<>();

    Produto mouse = new Produto("Mouse gamer", 40.90);
    Produto teclado = new Produto("Teclado gamer", 90.00);
    Produto notebook = new Produto("Notebook gamer", 2500.90);
    Produto headset = new Produto("Headset gamer", 250.50);

    Integer numeroDeProdutos = 0;

    public void adicionarAoCarrinho(ActionEvent event) {

        Button botaoClicado = (Button) event.getSource();
        String botaoId = botaoClicado.getId();

        switch (botaoId) {
            case "botao1":
                produtos.add(mouse);
                break;
            case "botao2":
                produtos.add(teclado);
                break;
            case "botao3":
                produtos.add(notebook);
                break;
            case "botao4":
                produtos.add(headset);
                break;
        }

        numeroDeProdutos += 1;
        
        mostrarProduto();
    }

    public void mostrarProduto() {
        numeroProdutos.setText(numeroDeProdutos + " itens no carrinho");

        listProdutos.getItems().clear();
        
        produtos.sort((p1,p2) -> p1.descricao().compareToIgnoreCase(p2.descricao()));

        for (var produto : produtos) {
            listProdutos.getItems().add(produto);
        }
    }
}

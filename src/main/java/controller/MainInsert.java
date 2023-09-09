package controller;

import dao.ProdutoDAO;
import model.Produto;

public class MainInsert {


    public void metodoInsert(String nomeProduto,  String marcaProduto, int precoProduto, int idCategoria){
        Produto produto = new Produto(nomeProduto, marcaProduto, precoProduto, idCategoria);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.insert(produto);
        produtoDAO.getListaProdutos().add(produto);
        System.out.println("Produto adicionado com sucesso!");
        System.out.println(produto.toString());
    }




}

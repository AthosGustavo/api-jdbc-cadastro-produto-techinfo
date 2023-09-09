package controller;

import dao.ProdutoDAO;
import model.Produto;

public class MainDelete {

    public void metodoDelete(int idProduto){
        Produto produto = new Produto(idProduto);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(produto);
    }
}

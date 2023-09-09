package controller;
import model.Produto;
import dao.ProdutoDAO;

public class MainUpdate {

    public void metodoUpdate(int idProduto, String nomeProduto, String marcaProduto, int precoProduto, int idCategoria){
        Produto produto = new Produto(idProduto, nomeProduto, marcaProduto, precoProduto, idCategoria);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.update(produto);

    }


}

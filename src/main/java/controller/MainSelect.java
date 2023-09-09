package controller;

import dao.ProdutoDAO;

public class MainSelect{

    public void metodoSelect(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.select();

    }




}

package dao;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection conexao;
    private ArrayList<Produto> listaProdutos;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    public ProdutoDAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//Aqui é carregada a classe do DriverManager
            this.conexao = DriverManager.getConnection("jdbc:mysql://localhost/techinfodb","root","At0345732544");
            this.listaProdutos = new ArrayList<Produto>();
        }catch(ClassNotFoundException e){
            e.printStackTrace();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("A conexão falhou");
        }
        //A classe DriverManager usa o método getConnection da interface Connection para abrir uma conexão com o banco de dados
    }

    public List<Produto> select(){
       String query = "SELECT * FROM produtos";

       //Interface variavel = classe.metodo() instancia objeto
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("id_produto"));
                produto.setNomeProduto(resultSet.getString("nome_produto"));
                produto.setMarcaProduto(resultSet.getString("marca_produto"));
                produto.setPrecoProduto(resultSet.getInt("preco_produto"));
                produto.setIdCategoria(resultSet.getInt("id_categoria"));
                System.out.println(produto.toString());
                listaProdutos.add(produto);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

       return listaProdutos;
    }

    public void insert(Produto produto){
        String query = "INSERT INTO produtos (nome_produto, marca_produto, preco_produto,  id_categoria)VALUES(?, ?, ?,?)";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1,produto.getNomeProduto());
            preparedStatement.setString(2,produto.getMarcaProduto());
            preparedStatement.setInt(3,produto.getPrecoProduto());
            preparedStatement.setInt(4,produto.getIdCategoria());
            preparedStatement.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public boolean update(Produto produto){
        String query = "UPDATE produtos SET nome_produto = ?, marca_produto = ?, preco_produto = ?, id_categoria = ? WHERE id_produto = ?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1,produto.getNomeProduto());
            preparedStatement.setString(2,produto.getMarcaProduto());
            preparedStatement.setInt(3,produto.getPrecoProduto());
            preparedStatement.setInt(4,produto.getIdCategoria());
            preparedStatement.setInt(5,produto.getIdProduto());
            preparedStatement.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public void delete(Produto produto){
        //DELETE FROM tabela WHERE idProduto  = ?
        String query = "DELETE FROM produtos WHERE id_produto  = ?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1,produto.getIdProduto());
            preparedStatement.execute();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Método para verificar se os produtos estão sendo adicionados,apagados e removidos da lista

}

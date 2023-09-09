package model;

public class Produto {

    private int idProduto;

    private String nomeProduto;

    private String marcaProduto;
    private int precoProduto;
    private int idCategoria;

    public Produto(){}

    public Produto(int idProduto){
        this.idProduto = idProduto;
    }

    public Produto(String nomeProduto, String marcaProduto, int precoProduto, int idCategoria){
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.precoProduto = precoProduto;
        this.idCategoria = idCategoria;

    }

    public Produto(int idProduto,String nomeProduto, String marcaProduto, int precoProduto, int idCategoria ){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.precoProduto = precoProduto;
        this.idCategoria = idCategoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(int precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int id_produto) {
        this.idProduto = id_produto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id produto=" + getIdProduto() +
                ",  nome=" + getNomeProduto() +
                ", preço=" + getPrecoProduto() +
                ", marca=" + getMarcaProduto() +
                ", id categoria=" + getIdCategoria() +
                "}";
    }



}

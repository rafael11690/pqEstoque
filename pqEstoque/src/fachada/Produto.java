/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Guil
 */
public class Produto {
    
    private int idProduto;
    private String nome;
    private String preco;
    private Boolean visivel;
    private int qnt;
    private int categoria;
    private String precoCusto;
    private int qntMinima;

    public int getQntMinima() {
        return qntMinima;
    }

    public void setQntMinima(int qntMinima) {
        this.qntMinima = qntMinima;
    }

    public Produto() {
    }

    public Produto(String nome, String preco, Boolean visivel, int qnt, int categoria, String precoCusto, int qntMinima) {
        this.nome = nome;
        this.preco = preco;
        this.visivel = visivel;
        this.qnt = qnt;
        this.categoria = categoria;
        this.precoCusto = precoCusto;
        this.qntMinima = qntMinima;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(String precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public Produto(String nome,String preco){
        this.nome = nome;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Rafael
 */
public class HistSaidaProdutoMP {

    private int id, idProd, idDest;
    private String data, preco, qnt;

    public HistSaidaProdutoMP() {
    }

    public HistSaidaProdutoMP(int idProd, int idDest, String qnt, String data, String preco) {
        this.idProd = idProd;
        this.idDest = idDest;
        this.qnt = qnt;
        this.data = data;
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDest() {
        return idDest;
    }

    public void setIdDest(int idDest) {
        this.idDest = idDest;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQnt() {
        return qnt;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }
}

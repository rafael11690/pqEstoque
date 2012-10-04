/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author miserani
 */
public class FormaPagamento {

    private int idformaPAgamento;
    private String descricao;
    private int tipoDePagamento;

    public FormaPagamento(String descricao, int tipoDePagamento) {
        this.descricao = descricao;
        this.tipoDePagamento = tipoDePagamento;
    }

    public FormaPagamento() {
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(int tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public int getIdformaPAgamento() {
        return idformaPAgamento;
    }

    public void setIdformaPAgamento(int idformaPAgamento) {
        this.idformaPAgamento = idformaPAgamento;
    }
}

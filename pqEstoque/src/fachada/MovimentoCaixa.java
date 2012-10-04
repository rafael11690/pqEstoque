/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Guil
 */
public class MovimentoCaixa {

    private int idMovimentoCaixa;
    private String Data;
    private int formaPagamento;
    private String valor;
    private String descricao;

    public MovimentoCaixa() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getIdMovimentoCaixa() {
        return idMovimentoCaixa;
    }

    public void setIdMovimentoCaixa(int idMovimentoCaixa) {
        this.idMovimentoCaixa = idMovimentoCaixa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}

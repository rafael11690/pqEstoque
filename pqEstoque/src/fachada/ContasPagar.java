/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import persistencia.ConsultaContasPagarMySQL;

/**
 *
 * @author Rafael
 */
public class ContasPagar {

    private int idcontas;
    private String data;
    private String descricao;
    private int tipo;
    private String valor;
    private int status;

    public ContasPagar() {
    }

    public ContasPagar(String data, String descricao, int tipo, String valor, int status) {
        this.data = data;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
    }

    public void darBaixa(int id) {
        ConsultaContasPagarMySQL c = new ConsultaContasPagarMySQL();
        c.darBaixa(id);
    }

    public void cadastrar() {
        ConsultaContasPagarMySQL c = new ConsultaContasPagarMySQL();
        c.cadastrar(this);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdcontas() {
        return idcontas;
    }

    public void setIdcontas(int idcontas) {
        this.idcontas = idcontas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}

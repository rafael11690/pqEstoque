/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.FormaPagamento;
import java.util.ArrayList;
import persistencia.ConsultaFormaPagamentoCompraMySQL;

/**
 *
 * @author Rafael
 */
public class FormaPagamentoCompraController {

    FormaPagamento formaPagamento = new FormaPagamento();
    ArrayList<FormaPagamento> listaFormaPagamento = new ArrayList<FormaPagamento>();

    public FormaPagamentoCompraController() {
    }

    public int getIdFormaPagamento(String forma) {
        for (int i = 0; i < this.listaFormaPagamento.size(); i++) {
            if (this.listaFormaPagamento.get(i).getDescricao().equals(forma)) {
                return listaFormaPagamento.get(i).getIdformaPAgamento();
            }
        }
        return 0;
    }

    public void buscarFormaPagamento() {
        ConsultaFormaPagamentoCompraMySQL consultasFormaDePagamentoMySQL = new ConsultaFormaPagamentoCompraMySQL();
        this.listaFormaPagamento = consultasFormaDePagamentoMySQL.buscarFormaPagamento();
    }

    public ArrayList<FormaPagamento> getListFormaPagamento() {
        return listaFormaPagamento;
    }

    public void setListFormaPagamento(ArrayList<FormaPagamento> listFormaPagamentos) {
        this.listaFormaPagamento = listFormaPagamentos;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPAgamento) {
        this.formaPagamento = formaPAgamento;
    }

    public void getFormaPagamento(int id) {
        for (int i = 0; i < this.listaFormaPagamento.size(); i++) {
            if (this.listaFormaPagamento.get(i).getIdformaPAgamento() == id) {
                formaPagamento = listaFormaPagamento.get(i);
            }
        }
    }
}

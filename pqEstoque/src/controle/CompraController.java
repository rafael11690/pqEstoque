/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.ContasPagar;
import fachada.Fornecedor;
import fachada.MovimentoCaixa;
import fachada.Produto;
import java.util.ArrayList;
import persistencia.ConsultaMovimentoCaixaMySQL;
import persistencia.ConsultaProdutoMySQL;

/**
 *
 * @author Rafael
 */
public class CompraController {

    private ArrayList<Produto> pedido = new ArrayList<Produto>();
    private String valorFinal;
    private int formaPagamento;
    private String data;

    public CompraController() {
    }

    
    
    public String finalizarCompra(int tipo, Fornecedor f) {
        ConsultaProdutoMySQL cp = new ConsultaProdutoMySQL();
        ConsultaMovimentoCaixaMySQL cm = new ConsultaMovimentoCaixaMySQL();
        ContasPagar contas = new ContasPagar();
        contas.setDescricao(f.getEmpresa());
        contas.setData(data);
        contas.setTipo(formaPagamento);
        contas.setValor(valorFinal);
        if (tipo == 0) {
            contas.setStatus(0);
        } else {
            contas.setStatus(1);
            MovimentoCaixa m = new MovimentoCaixa();
            m.setData(data);
            m.setDescricao("Pagamento p/ " + f.getEmpresa());
            m.setFormaPagamento(formaPagamento);
            m.setValor("-" + valorFinal);
            cm.cadastrarItemCaixa(m);
        }
        contas.cadastrar();
        for (int i = 0; i < pedido.size(); i++) {
            cp.updateCompra(pedido.get(i));
        }
        pedido = new ArrayList<Produto>();
        return "Compra finalizada com sucesso";
    }

    public void editar(Produto p, Produto novo) {
        for (int i = 0; i < pedido.size(); i++) {
            if (p.getIdProduto() == pedido.get(i).getIdProduto()
                    && p.getPrecoCusto().equals(pedido.get(i).getPrecoCusto())
                    && p.getQnt() == pedido.get(i).getQnt()) {
                pedido.get(i).setPrecoCusto(novo.getPrecoCusto());
                pedido.get(i).setQnt(novo.getQnt());
            }
        }
    }

    public Produto getProduto(int id, int qnt, String valor) {
        Produto p = new Produto();
        for (int i = 0; i < pedido.size(); i++) {
            if (pedido.get(i).getIdProduto() == id
                    && pedido.get(i).getPrecoCusto().equals(valor)
                    && pedido.get(i).getQnt() == qnt) {
                return pedido.get(i);
            }
        }
        return p;
    }

    public void excluir(int id, int qnt, String valor) {
        for (int i = 0; i < pedido.size(); i++) {
            if (pedido.get(i).getIdProduto() == id
                    && pedido.get(i).getPrecoCusto().equals(valor)
                    && pedido.get(i).getQnt() == qnt) {
                pedido.remove(i);
            }
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < pedido.size(); i++) {
            total += pedido.get(i).getQnt() * Double.parseDouble(pedido.get(i).getPrecoCusto().replace(",", "."));
        }
        return total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<Produto> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Produto> pedido) {
        this.pedido = pedido;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.HistSaidaProdutoMP;
import java.util.ArrayList;
import persistencia.HistSaidaMPMySQL;

/**
 *
 * @author Rafael
 */
public class HistSaidaProdutoMPController {

    private HistSaidaProdutoMP hist = new HistSaidaProdutoMP();
    private ArrayList<HistSaidaProdutoMP> lista = new ArrayList<HistSaidaProdutoMP>();

    public void cadastrar() {
        ProdutoController p = new ProdutoController();
        p.buscarProdutos();
        HistSaidaMPMySQL consultaHistorico = new HistSaidaMPMySQL();
        for (int i = 0; i < lista.size(); i++) {
            int buscaSaidaProdutos = consultaHistorico.buscaHistoricoSaidaProdutosIguais(lista.get(i));
            if (buscaSaidaProdutos > 0) {
                lista.get(i).setQnt(lista.get(i).getQnt() + buscaSaidaProdutos);
                consultaHistorico.updateHistoricoSaidaProdutosIguais(lista.get(i));
            } else {
                consultaHistorico.insertHistoricoSaidaProdutos(lista.get(i));
            }
            p.getProduto(lista.get(i).getIdProd());
            if (p.getProduto().getCategoria() == 2) {
                p.registrarSaida(lista.get(i).getQnt());
            }
        }
        lista = new ArrayList<HistSaidaProdutoMP>();
    }

    public void excluir(int i) {
        lista.remove(i);
    }

    public void editar(HistSaidaProdutoMP h, int row) {
        lista.set(row, h);
    }

    public HistSaidaProdutoMP getHist() {
        return hist;
    }

    public void setHist(HistSaidaProdutoMP hist) {
        this.hist = hist;
    }

    public ArrayList<HistSaidaProdutoMP> getLista() {
        return lista;
    }

    public void setLista(ArrayList<HistSaidaProdutoMP> lista) {
        this.lista = lista;
    }
}

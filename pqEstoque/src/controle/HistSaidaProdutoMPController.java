/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.HistSaidaProdutoMP;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class HistSaidaProdutoMPController {

    private HistSaidaProdutoMP hist = new HistSaidaProdutoMP();
    private ArrayList<HistSaidaProdutoMP> lista = new ArrayList<HistSaidaProdutoMP>();

    public void cadastrar(){
        
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

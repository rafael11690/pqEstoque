/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Fornecedor;
import java.text.Normalizer;
import java.util.ArrayList;
import persistencia.ConsultaFornecedorMySQL;

/**
 *
 * @author Rafael
 */
public class FornecedorController {

    Fornecedor fornecedor = new Fornecedor();
    ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

    public FornecedorController() {
    }

    public String cadastrar() {
        limparFormatacaoTelefone();
        ConsultaFornecedorMySQL consultaMySQL = new ConsultaFornecedorMySQL();
        return consultaMySQL.cadastrarFornecedor(fornecedor);
    }

    public String editar() {
        ConsultaFornecedorMySQL consultaMySQL = new ConsultaFornecedorMySQL();
        return consultaMySQL.editaFornecedor(fornecedor);
    }

    public void buscarFornecedores() {
        ConsultaFornecedorMySQL c = new ConsultaFornecedorMySQL();
        listaFornecedores = c.buscarFornecedores();
    }

    public String excluirFornecedor() {
        ConsultaFornecedorMySQL c = new ConsultaFornecedorMySQL();
        return c.excluirFornecedor(fornecedor);
    }

    public ArrayList<Fornecedor> buscaDinamicaFornecedores(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        for (int i = 0; i < listaFornecedores.size(); i++) {
            String comp = listaFornecedores.get(i).getEmpresa();
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                fornecedores.add(listaFornecedores.get(i));
            }
        }
        return fornecedores;
    }

    public void limparFormatacaoTelefone() {
        String tel1 = fornecedor.getTelefone1().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        fornecedor.setTelefone1(tel1);
        String tel2 = fornecedor.getTelefone2().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        fornecedor.setTelefone2(tel2);
    }

    public void getFornecedor(int id) {
        for (int i = 0; i < this.listaFornecedores.size(); i++) {
            if (this.listaFornecedores.get(i).getIdFornecedor() == id) {
                fornecedor = listaFornecedores.get(i);
            }
        }
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<Fornecedor> getListaFornecedores() {
        return listaFornecedores;
    }

    public void setListaFornecedores(ArrayList<Fornecedor> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }
}

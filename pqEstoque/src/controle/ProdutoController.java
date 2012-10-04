/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Produto;
import java.text.Normalizer;
import java.util.ArrayList;
import persistencia.ConsultaProdutoMySQL;
import persistencia.ConsultasProdutoMySQL;

/**
 *
 * @author Rafael
 */
public class ProdutoController {

    Produto produto = new Produto();
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    public ProdutoController() {
    }

    public void estornar(int idProd, int quantidade) {
        ConsultaProdutoMySQL c = new ConsultaProdutoMySQL();
        c.updateQntDoProdutoEstorno(quantidade, idProd);
    }

    public ArrayList<String> getProdsQntMinima() {
        ArrayList<String> aux = new ArrayList<String>();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getQnt() < listaProdutos.get(i).getQntMinima()) {
                aux.add(listaProdutos.get(i).getNome());
            }
        }
        return aux;
    }

    public ArrayList<Produto> getProdsQntMinimaProduto() {
        ArrayList<Produto> aux = new ArrayList<Produto>();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getQnt() < listaProdutos.get(i).getQntMinima()) {
                aux.add(listaProdutos.get(i));
            }
        }
        return aux;
    }

    public String cadastrar() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        return consultaProdutoMySQL.cadastrarProduto(produto);
    }

    public String editar() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        return consultaProdutoMySQL.editarProduto(produto);
    }

    public String excluirProduto() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        return consultaProdutoMySQL.excluirProduto(produto);
    }

    public void buscarProdutos() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        this.listaProdutos = consultaProdutoMySQL.buscarProduto();
    }

    public void buscarProdutosCompra() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        this.listaProdutos = consultaProdutoMySQL.buscarProdutoCompra();
    }

    public void buscarProdutosTotal() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        this.listaProdutos = consultaProdutoMySQL.buscarProdutoTotal();
    }

    public void buscarProdutosHist() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        this.listaProdutos = consultaProdutoMySQL.buscarProdutoHist();
    }

    public void buscarProdutosCategoria(int categoria) {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        this.listaProdutos = consultaProdutoMySQL.buscarProdutoCategoria(categoria);
    }

    public ArrayList<Produto> buscaDinamicaProdutos(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        for (int i = 0; i < listaProdutos.size(); i++) {
            String comp = listaProdutos.get(i).getNome();
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                produtos.add(listaProdutos.get(i));
            }
        }
        return produtos;
    }

    public ArrayList<Produto> getListProdutos() {
        return listaProdutos;
    }

    public void setListProdutos(ArrayList<Produto> listProdutos) {
        this.listaProdutos = listProdutos;
    }

//    public Produto getProduto(int id) {
//        return produto;
//    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void getProduto(int id) {
        produto = null;
        for (int i = 0; i < this.listaProdutos.size(); i++) {
            if (this.listaProdutos.get(i).getIdProduto() == id) {
                produto = listaProdutos.get(i);
            }
        }
    }
}

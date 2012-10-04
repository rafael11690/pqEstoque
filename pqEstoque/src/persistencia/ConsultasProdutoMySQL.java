/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ConsultasProdutoMySQL {

    private static final String SQL_EXCLUIR_PRODUTO = "UPDATE produtos SET visivel=0 WHERE codigo_produto=?";
    private static final String SQL_BUSCA_PRODUTO_CATEGORIA = "SELECT * FROM produtos WHERE visivel=1 AND idCategoria=? ORDER BY nome";
    private static final String SQL_BUSCA_PRODUTO = "SELECT * FROM produtos WHERE visivel=1  ORDER BY nome";
    private static final String SQL_BUSCA_PRODUTO_COMPRA = "SELECT * FROM produtos WHERE visivel=1 AND idCategoria<>0 ORDER BY nome";
    private static final String SQL_BUSCA_PRODUTO_HIST = "SELECT * FROM produtos WHERE idCategoria<>2 ORDER BY idCategoria, nome";
    private static final String SQL_INCLUIR_PRODUTO = "INSERT INTO produtos (nome, preco_venda, preco_custo, quantidade, idCategoria,estoque_minimo) "
            + "VALUES (?, ?, ?, ?, ?,?)";
    private static final String SQL_EDITAR_PRODUTO = "UPDATE produtos SET nome=?, preco_venda=?, preco_custo=?, quantidade=? , estoque_minimo=? WHERE codigo_produto=? ";
    private static final String SQL_BUSCA_PRODUTO_TOTAL = "SELECT * FROM produtos ORDER BY nome";

    public ConsultasProdutoMySQL() {
    }

    public ArrayList<Produto> buscarProdutoHist() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String query = SQL_BUSCA_PRODUTO_HIST;

        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco_venda"));
                prod.setCategoria(rs.getInt("idCategoria"));
                prod.setQnt(rs.getInt("quantidade"));
                prod.setPrecoCusto(rs.getString("preco_custo"));
                prod.setVisivel(rs.getInt("visivel") == 1);
                prod.setQntMinima(rs.getInt("estoque_minimo"));
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }

    public String excluirProduto(Produto prod) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EXCLUIR_PRODUTO);
            stmt.setInt(1, prod.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Exclusão do Produto não foi efetuada";
        }
        return "Exclusão do Produto efetuada com sucesso!";
    }

    public String cadastrarProduto(Produto prod) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR_PRODUTO);
            stmt.setString(1, prod.getNome());
            stmt.setString(2, prod.getPreco());
            stmt.setString(3, prod.getPrecoCusto());
            stmt.setInt(4, prod.getQnt());
            stmt.setInt(5, prod.getCategoria());
            stmt.setInt(6, prod.getQntMinima());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Cadastro do Produto não foi efetuada";
        }
        return "Cadastro do Produto efetuado com sucesso!";
    }

    public String editarProduto(Produto prod) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EDITAR_PRODUTO);
            stmt.setString(1, prod.getNome());
            stmt.setString(2, prod.getPreco());
            stmt.setString(3, prod.getPrecoCusto());
            stmt.setInt(4, prod.getQnt());
            stmt.setInt(5, prod.getQntMinima());
            stmt.setInt(6, prod.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Erro na alteração do Produto";
        }
        return "Produto alterado com sucesso ";
    }

    public ArrayList<Produto> buscarProdutoCategoria(int categoria) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_PRODUTO_CATEGORIA);
            stmt.setInt(1, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco_venda"));
                prod.setPrecoCusto(rs.getString("preco_custo"));
                prod.setQnt(rs.getInt("quantidade"));
                prod.setCategoria(rs.getInt("idCategoria"));
                prod.setQntMinima(rs.getInt("estoque_minimo"));
                produtos.add(prod);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return produtos;
    }

    public ArrayList<Produto> buscarProduto() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_PRODUTO);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco_venda"));
                prod.setPrecoCusto(rs.getString("preco_custo"));
                prod.setQnt(rs.getInt("quantidade"));
                prod.setCategoria(rs.getInt("idCategoria"));
                prod.setQntMinima(rs.getInt("estoque_minimo"));
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }

    public ArrayList<Produto> buscarProdutoCompra() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_PRODUTO_COMPRA);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco_venda"));
                prod.setPrecoCusto(rs.getString("preco_custo"));
                prod.setQnt(rs.getInt("quantidade"));
                prod.setCategoria(rs.getInt("idCategoria"));
                prod.setQntMinima(rs.getInt("estoque_minimo"));
                produtos.add(prod);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return produtos;
    }

    public ArrayList<Produto> buscarProdutoTotal() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_PRODUTO_TOTAL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco_venda"));
                prod.setPrecoCusto(rs.getString("preco_custo"));
                prod.setQnt(rs.getInt("quantidade"));
                prod.setCategoria(rs.getInt("idCategoria"));
                prod.setQntMinima(rs.getInt("estoque_minimo"));
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }
}

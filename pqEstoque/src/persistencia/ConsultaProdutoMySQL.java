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
 * @author Guil
 */
public class ConsultaProdutoMySQL {

    private static final String SQL_BUSCA_PRODUTO = "SELECT * FROM produtos WHERE visivel=1 AND quantidade<>0 AND idCategoria<>2 ORDER BY nome ";
    private static final String SQL_BUSCA_PRODUTO_ID = "SELECT * FROM produtos WHERE  codigo_produto=?";
    private static final String SQL_UPDATE = "UPDATE produtos SET quantidade=? WHERE codigo_produto=?";
    private static final String SQL_UPDATE_ESTORNO = "UPDATE produtos SET quantidade=quantidade+? WHERE codigo_produto=?";
    private static final String SQL_UPDATE_COMPRA = "UPDATE produtos SET quantidade=quantidade+?, preco_custo=? WHERE codigo_produto=?";

    public ConsultaProdutoMySQL() {
    }

    public ArrayList<Produto> buscarProduto() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String query = SQL_BUSCA_PRODUTO;

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
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }

    public Produto buscarProduto(int idProd) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_PRODUTO_ID);
            stmt.setInt(1, idProd);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco_venda"));
                prod.setCategoria(rs.getInt("idCategoria"));
                prod.setQnt(rs.getInt("quantidade"));
                prod.setPrecoCusto(rs.getString("preco_custo"));
                prod.setVisivel(rs.getInt("visivel") == 1);
                return prod;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void updateQntDoProduto(int quantidade, int idProduto) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, quantidade);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateQntDoProdutoEstorno(int quantidade, int idProduto) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE_ESTORNO);
            stmt.setInt(1, quantidade);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void updateCompra(Produto p) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE_COMPRA);
            stmt.setInt(1, p.getQnt());
            stmt.setString(2, p.getPrecoCusto());
            stmt.setInt(3, p.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
}

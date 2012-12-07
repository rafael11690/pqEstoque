
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.HistSaidaProdutoMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class HistSaidaMPMySQL {

    private static final String SQL_BUSCA = "SELECT * FROM historico_saida_mp WHERE idProduto=? AND data=? AND destino=?";
    private static final String SQL_UPDATE = "UPDATE historico_saida_mp SET quantidade=? WHERE idProduto=? AND data=? AND iddestino=?";
    private static final String SQL_INCLUIR = "INSERT INTO historico_saida_mp(idProduto,data,quantidade,destino,preco_custo)"
            + "VALUES (?,?,?,?,?)";

    public int buscaHistoricoSaidaProdutosIguais(HistSaidaProdutoMP historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA);

            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setInt(3, historicoProduto.getIdDest());

            ResultSet rs = stmt.executeQuery();
            con.close();
            while (rs.next()) {
                return rs.getInt("quantidade");
            }
        } catch (SQLException ex) {
        }

        return 0;
    }

    public void updateHistoricoSaidaProdutosIguais(HistSaidaProdutoMP historicoProduto) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, historicoProduto.getQnt());
            stmt.setInt(2, historicoProduto.getIdProd());
            stmt.setString(3, historicoProduto.getData());
            stmt.setInt(4, historicoProduto.getIdDest());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertHistoricoSaidaProdutos(HistSaidaProdutoMP historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setString(3, historicoProduto.getQnt());
            stmt.setInt(4, historicoProduto.getIdDest());
            stmt.setString(5, historicoProduto.getPreco());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }
}

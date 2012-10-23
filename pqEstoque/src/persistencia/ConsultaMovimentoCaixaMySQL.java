/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import fachada.MovimentoCaixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guil
 */
public class ConsultaMovimentoCaixaMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO movimento_caixa(data, forma_pagamento, valor, descricao) VALUES (?, ?, ?, ?)";
    private static final String SQL_BUSCAR = "SELECT * FROM movimento_caixa";
    private static final String SQL_EXCLUIR = "DELETE FROM movimento_caixa WHERE idmovimento_caixa=?";

    public ConsultaMovimentoCaixaMySQL() {
    }

    public void cadastrarItemCaixa(MovimentoCaixa mCaixa) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_INCLUIR);
            stmt.setString(1, mCaixa.getData());
            stmt.setInt(2, mCaixa.getFormaPagamento());
            stmt.setString(3, mCaixa.getValor());
            stmt.setString(4, mCaixa.getDescricao());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void excluirMovimento(int id) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_EXCLUIR);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }

    public ArrayList<MovimentoCaixa> buscarTodos() {
        ArrayList<MovimentoCaixa> retorno = new ArrayList<MovimentoCaixa>();
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(SQL_BUSCAR);
            while (rs.next()) {
                MovimentoCaixa aux = new MovimentoCaixa();
                aux.setIdMovimentoCaixa(rs.getInt("idmovimento_caixa"));
                aux.setData(rs.getString("data"));
                aux.setFormaPagamento(rs.getInt("forma_pagamento"));
                aux.setValor(rs.getString("valor"));
                aux.setDescricao(rs.getString("descricao"));
                retorno.add(aux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaMovimentoCaixaMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}

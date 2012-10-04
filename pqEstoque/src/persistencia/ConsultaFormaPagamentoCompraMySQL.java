/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miserani
 */
public class ConsultaFormaPagamentoCompraMySQL {

    private static final String SQL_BUSCA_FORMA_PAGAMENTO = "SELECT * FROM forma_pagamento_compra ORDER BY descricao";
    private static final String SQL_BUSCAR_FORMA_PAGAMENTO_DESCRICAO = "SELECT idforma_pagamento_compra FROM forma_pagamento_compra WHERE descricao=?";
    private static final String SQL_BUSCAR_FORMA_PAGAMENTO_ID = "SELECT descricao FROM forma_pagamento_compra WHERE idforma_pagamento_compra=?";

    public ConsultaFormaPagamentoCompraMySQL() {
    }

    public String buscarNomeForma(int id) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_FORMA_PAGAMENTO_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("descricao");
            }
        } catch (SQLException ex) {
        }
        return "Erro";
    }

    public int buscarIdForma(String nome) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_FORMA_PAGAMENTO_DESCRICAO);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idforma_pagamento_compra");
            }
        } catch (SQLException ex) {
        }
        return 0;
    }

    public ArrayList<FormaPagamento> buscarFormaPagamento() {
        ArrayList<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
        String query = SQL_BUSCA_FORMA_PAGAMENTO;

        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setIdformaPAgamento(rs.getInt("idforma_pagamento_compra"));
                formaPagamento.setDescricao(rs.getString("descricao"));
                formaPagamento.setTipoDePagamento(rs.getInt("tipo"));
                formaPagamentos.add(formaPagamento);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formaPagamentos;
    }
}

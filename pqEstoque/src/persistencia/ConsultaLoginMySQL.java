/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class ConsultaLoginMySQL {

    private static final String busca_senha = "SELECT * FROM senhas WHERE idsenhas=?";

    public ConsultaLoginMySQL() {
    }

    public String buscarLogin(int sistema) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(busca_senha);
            stmt.setInt(1, sistema);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("senha");
            }
            con.close();
        } catch (SQLException ex) {
        }
        return null;
    }
}

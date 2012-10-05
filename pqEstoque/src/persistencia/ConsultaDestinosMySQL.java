/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rafael
 */
public class ConsultaDestinosMySQL {

    private static final String SQL_BUSCA = "SELECT * FROM destino";

    public HashMap<Integer, String> buscarDestinos() {
        HashMap<Integer, String> destinos = new HashMap<Integer, String>();
        String query = SQL_BUSCA;

        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                destinos.put(rs.getInt("iddestino"), rs.getString("descricao"));
            }
        } catch (SQLException ex) {
        }
        return destinos;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ConsultaFornecedorMySQL {

    private static final String SQL_EXCLUIR_FORNECEDOR = " DELETE FROM fornecedor WHERE idfornecedor=?";
    private static final String SQL_BUSCA_FORNECEDOR = "SELECT * FROM fornecedor ORDER BY empresa";
    private static final String SQL_INCLUIR_FORNECEDOR = "INSERT INTO fornecedor (empresa, endereco, cnpj, ie, email, telefone1, telefone2, vendedor) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_EDITAR_FORNECEDOR = "UPDATE fornecedor SET empresa=?, endereco=?, cnpj=?, ie=?, email=?, telefone1=?, telefone2=?, vendedor=? WHERE idfornecedor=? ";

    public ConsultaFornecedorMySQL() {
    }

    public String excluirFornecedor(Fornecedor fornecedor) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EXCLUIR_FORNECEDOR);
            stmt.setInt(1, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Exclusão do Fornecedor não foi efetuada";
        }
        return "Exclusão do fornecedor efetuada com sucesso!";
    }

    public String editaFornecedor(Fornecedor fornecedor) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EDITAR_FORNECEDOR);
            stmt.setString(1, fornecedor.getEmpresa());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getIe());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getTelefone1());
            stmt.setString(7, fornecedor.getTelefone2());
            stmt.setString(8, fornecedor.getVendedor());
            stmt.setInt(9, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            return "Erro na alteração do fornecedor";
        }
        return "Fornecedor alterado com sucesso!";
    }

    public String cadastrarFornecedor(Fornecedor fornecedor) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR_FORNECEDOR);
            stmt.setString(1, fornecedor.getEmpresa());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getIe());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getTelefone1());
            stmt.setString(7, fornecedor.getTelefone2());
            stmt.setString(8, fornecedor.getVendedor());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            return "Cadastro do Fornecedor não foi efetuado";
        }
        return "Cadastro efetuado com sucesso!";
    }

    public ArrayList<Fornecedor> buscarFornecedores() {
        ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        String query = SQL_BUSCA_FORNECEDOR;
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                Fornecedor c = new Fornecedor();
                c.setIdFornecedor(rs.getInt("idfornecedor"));
                c.setEmpresa(rs.getString("empresa"));
                c.setEndereco(rs.getString("endereco"));
                c.setCnpj(rs.getString("cnpj"));
                c.setIe(rs.getString("ie"));
                c.setEmail(rs.getString("email"));
                c.setTelefone1(rs.getString("telefone1"));
                c.setTelefone2(rs.getString("telefone2"));
                c.setVendedor(rs.getString("vendedor"));
                fornecedor.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return fornecedor;
    }
}

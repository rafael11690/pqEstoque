package persistencia;

/*
 *
 * @author Mariane Moreira de Souza
 *
 */
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Esta classe tem os m�todos est�ticos para a conex�o e fechamento de conex�o
 * com o banco de dados em um sistema monousu�rio
 */
public class ConexaoMySQL {

    static java.sql.Statement st;
    private static Component root;

    /**
     * Construtor da classe DataBase
     */
    public ConexaoMySQL() {
    }

    /**
     * M�todo para abrir uma conex�o com o banco
     *
     * @return conexao Conex�o com o banco
     *
     */
    //a conex�o � criada uma �nica vez, no momento em que o objeto ConexaoMySQL � criado (no momento da realiza��o da primeira
    //consulta ou atualiza��o no banco;
    public static java.sql.Statement getInstance() throws SQLException {
        if (st == null) {
            try {
                Connection con = conectar();
                st = con.createStatement();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(root, "Não foi possível conectar ao servidor (192.168.0.101)\nVerifique sua conexão e tente novamente.");
                System.exit(0);
            }
        }
        return st;
    }

    public static Connection conectar() {
        try {
            // Carregando o JDBC Driver padrão  
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//  

            String url = "jdbc:mysql://127.0.0.1:3306/paodequeijo";
            String username = "root";        //nome de um usuário de seu BD        
            String password = "root";      //sua senha de acesso
//            

//            String url = "jdbc:mysql://200.131.224.101:2200/paodequeijo";
//            String username = "paode";        //nome de um usuário de seu BD        
//            String password = "queijo";      //sua senha de acesso  
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado  
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.  " + e);
            return null;
        }
    }
}

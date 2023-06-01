
package conexao;

import java.sql.DriverManager;


public class ConexaoMySQL {
    
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    private static final String URL_BANCO = "jdbc:mysql://localhost:3306/empresa";
    
    public static java.sql.Connection getConexao() throws Exception {
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Cria a conexao com o banco de dados
        return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);

    }
    
}


package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Pessoa;


public class PessoaDAO {
    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;
    
    public int inserir(Pessoa pessoa) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO pessoa(nome, data_nascimento) ")
                .append("VALUES (?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setString(1, pessoa.getNome());
            sql.setDate(2, new Date(pessoa.getDataNascimento().getTime()));
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return linha;
    }
    
    /*
    public List<Contato> listar() {
        
        String select = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<Contato>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Contato contato = new Contato();

                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contato.setDataCadastro(rset.getDate("datacadastro"));

                contatos.add(contato);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return contatos;
    }
    
    */
     
    private void fecharConexao() {
        try {
            if (rset != null) {
                rset.close();
            }
            if (sql != null) {
                sql.close();
            }

            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

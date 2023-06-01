
package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    
    public List<Pessoa> listar() {
        
        String select = "SELECT * FROM Pessoa";

        List<Pessoa> lista = new ArrayList<Pessoa>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setCodigo(rset.getInt("codigo"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setDataNascimento(rset.getDate("data_nascimento"));

                lista.add(pessoa);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return lista;
    }
    
   
     
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

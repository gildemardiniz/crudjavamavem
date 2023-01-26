package br.com.contato.dao;

import br.com.contato.factory.ConnectionFactory;
import br.com.contato.model.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {


    public void save(Contato contato){

        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO contatos(nome,idade,datacadastro) VALUES(?,?,?)";

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1,contato.getNome());
            pstm.setInt(2,contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{

            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
}

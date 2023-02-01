package br.com.contato.dao;

import br.com.contato.factory.ConnectionFactory;
import br.com.contato.model.Contato;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Salvo com sucesso");

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
    public List<Contato> getContatos(){

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        String sql = "SELECT * FROM contatos";
        List<Contato> contatos = new ArrayList<>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){

                Contato contato = new Contato();

                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contato.setDataCadastro(rset.getDate("datacadastro"));

                contatos.add(contato);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return contatos;
    }
    public void upadate(Contato contato){

        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? WHERE id = ?";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2,contato.getIdade());
            pstm.setDate(3,new Date(contato.getDataCadastro().getTime()));

            pstm.setInt(4, contato.getId());

            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }finally {

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

    public void deleteByID(int id) {

        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "DELETE FROM contatos WHERE id = ? ";

        try{

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
package br.com.contato.dao;

import br.com.contato.model.Contato;
import java.sql.Connection;

public class ContatoDAO {

    public void save(Contato contato){

        Connection conn = null;

        String sql = "INSERT INTO contatos(nome,idade,datacadastro) VALUES(?,?,?)";


    }

}

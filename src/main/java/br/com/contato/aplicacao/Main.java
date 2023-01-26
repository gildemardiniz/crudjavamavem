package br.com.contato.aplicacao;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.model.Contato;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();

        contato.setNome("Gildemar");
        contato.setIdade(34);
        contato.setDataCadastro(new Date());

        contatoDAO.save(contato);

    }
}

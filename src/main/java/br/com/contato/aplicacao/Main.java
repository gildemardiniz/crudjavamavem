package br.com.contato.aplicacao;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.model.Contato;

import java.util.Date;

public class Main {

    public static void main(String[] args) {



        //INSERT

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();

        contato.setNome("baunilha");
        contato.setIdade(2);
        contato.setDataCadastro(new Date());

       // contatoDAO.save(contato);



        //UPDATE

        Contato contato2 = new Contato();
        contato2.setNome("gildemar Muniz Diniz");
        contato2.setIdade(34);
        contato2.setDataCadastro(new Date());
        contato2.setId(2);

        //contatoDAO.upadate(contato2);

        // SELECT

        for (Contato c : contatoDAO.getContatos()){
            System.out.println("Contato: "+ c.getNome());
        }

        //DELETE ID

        contatoDAO.deleteByID(2);






    }
}

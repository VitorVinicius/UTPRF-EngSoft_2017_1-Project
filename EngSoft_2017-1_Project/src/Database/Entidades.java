/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Classes.Locatario;
import Classes.Pessoa;
import Classes.PessoaFisica;
import Classes.PessoaJuridica;
import Excecoes.EntidadeDesconhecidaExeption;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor
 */
public final class Entidades {
    public static List<Locatario> obterLocatarios() throws SQLException, ResultSetNuloOuVazioException, EntidadeDesconhecidaExeption{
        List<Locatario> locatarios = new ArrayList();
        try(ResultSet rs = Conector.obterDados("select * from pessoa;")){
                while(rs.next()){
                   long id = (rs.getLong("id"));
                   String nome = (rs.getString("nome"));
                   String rua = (rs.getString("rua"));
                   String numero = (rs.getString("numero"));
                   String cep = (rs.getString("cep"));
                   String bairro = (rs.getString("bairro"));
                   String cidade = (rs.getString("cidade"));
                   String tipo = (rs.getString("tipo"));
                   String cpf = (rs.getString("cpf"));
                   String dataNascimento = (rs.getString("dataNascimento"));
                   String razaoSocial = (rs.getString("razaoSocial"));
                   String nomeFantasia = (rs.getString("nomeFantasia"));
                   String incricaoEstadual = (rs.getString("incricaoEstadual"));
                   String cnpj = (rs.getString("cnpj"));
                   String uf = (rs.getString("uf"));
                   
                   
                   
                   Locatario locatario = null;
                   switch(tipo){
                       case "PessoaJuridica":
                           PessoaJuridica pJuridica = new PessoaJuridica();
                           pJuridica.setId(id);
                           pJuridica.setNome(nome);
                           pJuridica.setRua(rua);
                           pJuridica.setNumero(numero);
                           pJuridica.setCep(cep);
                           pJuridica.setBairro(bairro);
                           pJuridica.setCidade(cidade);
                           pJuridica.setUf(uf);
                           
                           pJuridica.setCnpj(cnpj);
                           pJuridica.setInscricaoEstadual(incricaoEstadual);
                           pJuridica.setRazaoSocial(razaoSocial);
                           pJuridica.setNomeFantasia(nomeFantasia);
                           locatario = pJuridica;
                       break;
                       
                       case "PessoaFisica":    
                           PessoaFisica pFisica = new PessoaFisica();
                           
                           pFisica.setId(id);
                           pFisica.setNome(nome);
                           pFisica.setRua(rua);
                           pFisica.setNumero(numero);
                           pFisica.setCep(cep);
                           pFisica.setBairro(bairro);
                           pFisica.setCidade(cidade);
                           pFisica.setUf(uf);
                           
                           pFisica.setCpf(cpf);
                           pFisica.setDataNascimento(dataNascimento);
                           
                           locatario = pFisica;
                       break;    
                       default:
                           throw new Excecoes.EntidadeDesconhecidaExeption("A entidade '"+ tipo + "' não é reconhecida [id: "+ id+"]");
                   }
                   locatarios.add(locatario);
                }
                rs.close();
           } 
        return locatarios;
    }
    
}

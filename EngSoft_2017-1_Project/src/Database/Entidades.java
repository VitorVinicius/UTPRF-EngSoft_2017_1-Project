/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Classes.Locatario;
import Excecoes.EntidadeDesconhecidaExeption;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
                   Date dataNascimento = (rs.getDate("dataNascimento"));
                   String razaoSocial = (rs.getString("razaoSocial"));
                   String nomeFantasia = (rs.getString("nomeFantasia"));
                   String incricaoEstadual = (rs.getString("incricaoEstadual"));
                   String cnpj = (rs.getString("cnpj"));
                   String uf = (rs.getString("uf"));
                   
                   Locatario locatario =  new Locatario();
                    locatario.setId(id);
                    locatario.setNome(nome);
                    locatario.setRua(rua);
                    locatario.setNumero(numero);
                    locatario.setCep(cep);
                    locatario.setBairro(bairro);
                    locatario.setCidade(cidade);
                    locatario.setUf(uf);
                    locatario.setTipo(tipo);
                    locatario.setCnpj(cnpj);
                    locatario.setInscricaoEstadual(incricaoEstadual);
                    locatario.setRazaoSocial(razaoSocial);
                    locatario.setNomeFantasia(nomeFantasia);

                    locatario.setCpf(cpf);
                    locatario.setDataNascimento(dataNascimento);
                    
                   locatarios.add(locatario);
                }
                rs.close();
           } 
        return locatarios;
    }
    
}

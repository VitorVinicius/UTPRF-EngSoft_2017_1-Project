/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Classes.Equipamento;
import Classes.Funcionario;
import Classes.Historico;
import Classes.Locatario;
import Classes.TipoOcorrencia;
import Classes.TipoLocatario;
import Excecoes.EntidadeDesconhecidaExeption;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vitor
 */
@Deprecated
public final class Entidades {
    @Deprecated
    public static List<Historico> obterHistorico(long id) throws SQLException{
        List<Historico> historicos = new ArrayList();
        PreparedStatement pstmt = Conector.getConexao().prepareStatement("SELECT * FROM `locadora`.`historico` where id = ?;");
        pstmt.setLong(1, id);
        try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                   Historico historico = new Historico();
                   long idEquipamento = (rs.getLong("idEquipamento"));
                   long idPessoa= (rs.getLong("idPessoa"));
                   int tipoOcorrencia = (rs.getInt("tipoOcorrencia"));
                   String descricao = (rs.getString("descricao"));
                   
                   historico.setId(id);
                   historico.setDescricao(descricao);
                   historico.setTipoOcorrencia(TipoOcorrencia.values()[tipoOcorrencia]);
                   
                   historicos.add(historico);
                }
                rs.close();
        }
        return historicos;
    }
    @Deprecated
    public static List<Historico> obterHistorico(Equipamento  equipamento) throws SQLException{
        List<Historico> historicos = new ArrayList();
        PreparedStatement pstmt = Conector.getConexao().prepareStatement("SELECT * FROM `locadora`.`historico` where idEquipamento = ?;");
        pstmt.setLong(1, equipamento.getId());
        try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                   Historico historico = new Historico();
                   long id = (rs.getLong("id"));
                   long idPessoa= (rs.getLong("idPessoa"));
                   int tipoOcorrencia = (rs.getInt("tipoOcorrencia"));
                   String descricao = (rs.getString("descricao"));
                   
                   historico.setId(id);
                   historico.setDescricao(descricao);
                   historico.setTipoOcorrencia(TipoOcorrencia.values()[tipoOcorrencia]);
                   
                   historicos.add(historico);
                }
                rs.close();
        }
        return historicos;
    }
    @Deprecated
    public static List<Historico> obterHistorico(Locatario  locatario) throws SQLException{
        List<Historico> historicos = new ArrayList();
        PreparedStatement pstmt = Conector.getConexao().prepareStatement("SELECT * FROM `locadora`.`historico` where idPessoa = ?;");
        pstmt.setLong(1, locatario.getId());
        try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                   Historico historico = new Historico();
                   long id = (rs.getLong("id"));
                   long idEquipamento = (rs.getLong("idEquipamento"));
                   int tipoOcorrencia = (rs.getInt("tipoOcorrencia"));
                   String descricao = (rs.getString("descricao"));
                   
                   historico.setId(id);
                   historico.setDescricao(descricao);
                   historico.setTipoOcorrencia(TipoOcorrencia.values()[tipoOcorrencia]);
                   
                   historicos.add(historico);
                }
                rs.close();
        }
        return historicos;
    }
    @Deprecated
    public static Funcionario obterFuncionario(long id) throws SQLException{
        Funcionario funcionario = null;
        PreparedStatement pstmt = Conector.getConexao().prepareStatement("select Pessoa.*, Funcionario.nis,Funcionario.salario,Funcionario.dataAdmissao from  Pessoa natural join Funcionario where id = ?;");
        pstmt.setLong(1, id);
        try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
        
                   String nome = (rs.getString("nome"));
                   String rua = (rs.getString("rua"));
                   int numero = (rs.getInt("numero"));
                   String cep = (rs.getString("cep"));
                   String bairro = (rs.getString("bairro"));
                   String cidade = (rs.getString("cidade"));
                   int tipo = (rs.getInt("tipo"));
                   String cpf = (rs.getString("cpf"));
                   Date dataNascimento = (rs.getDate("dataNascimento"));
                   String razaoSocial = (rs.getString("razaoSocial"));
                    String incricaoEstadual = (rs.getString("incricaoEstadual"));
                   String cnpj = (rs.getString("cnpj"));
                   String uf = (rs.getString("uf"));
                   String nis = (rs.getString("nis"));
                   Float salario = rs.getFloat("salario");
                   Date dataAdmissao = (rs.getDate("dataAdmissao"));
                   funcionario = new Funcionario();
                    funcionario.setId(id);
                    funcionario.setNome(nome);
                    funcionario.setRua(rua);
                    funcionario.setNumero(numero);
                    funcionario.setCep(cep);
                    funcionario.setBairro(bairro);
                    funcionario.setCidade(cidade);
                    funcionario.setUf(uf);
                    funcionario.setTipo(TipoLocatario.values()[tipo]);
                    funcionario.setCnpj(cnpj);
                    funcionario.setInscricaoEstadual(incricaoEstadual);
                    funcionario.setRazaoSocial(razaoSocial);
                    
                    funcionario.setCpf(cpf);
                    funcionario.setDataNascimento(dataNascimento);
                   
                    funcionario.setNis(nis);
                    funcionario.setSalario(salario);
                    funcionario.setDataAdmissao(dataAdmissao);
                }
                rs.close();
        }
        return funcionario;
    }
    
    @Deprecated
    public static List<Funcionario> obterFuncionarios() throws SQLException, ResultSetNuloOuVazioException{
        List<Funcionario> funcionarios = new ArrayList();
        
        try(ResultSet rs = Conector.obterDados("select Pessoa.*, Funcionario.nis,Funcionario.salario,Funcionario.dataAdmissao from  Pessoa natural join Funcionario;")){
                while(rs.next()){
                   Funcionario funcionario = new Funcionario();
                   long id = (rs.getLong("id"));
                   String nome = (rs.getString("nome"));
                   String rua = (rs.getString("rua"));
                   int numero = (rs.getInt("numero"));
                   String cep = (rs.getString("cep"));
                   String bairro = (rs.getString("bairro"));
                   String cidade = (rs.getString("cidade"));
                   int tipo = (rs.getInt("tipo"));
                   String cpf = (rs.getString("cpf"));
                   Date dataNascimento = (rs.getDate("dataNascimento"));
                   String razaoSocial = (rs.getString("razaoSocial"));
                   String incricaoEstadual = (rs.getString("incricaoEstadual"));
                   String cnpj = (rs.getString("cnpj"));
                   String uf = (rs.getString("uf"));
                   String nis = (rs.getString("nis"));
                   Float salario = rs.getFloat("salario");
                   Date dataAdmissao = (rs.getDate("dataAdmissao"));
                    funcionario.setId(id);
                    funcionario.setNome(nome);
                    funcionario.setRua(rua);
                    funcionario.setNumero(numero);
                    funcionario.setCep(cep);
                    funcionario.setBairro(bairro);
                    funcionario.setCidade(cidade);
                    funcionario.setUf(uf);
                    funcionario.setTipo(TipoLocatario.values()[tipo]);
                    funcionario.setCnpj(cnpj);
                    funcionario.setInscricaoEstadual(incricaoEstadual);
                    funcionario.setRazaoSocial(razaoSocial);
                   
                    funcionario.setCpf(cpf);
                    funcionario.setDataNascimento(dataNascimento);
                   
                    funcionario.setNis(nis);
                    funcionario.setSalario(salario);
                    funcionario.setDataAdmissao(dataAdmissao);
                    
                    funcionarios.add(funcionario);
                    
                }
                rs.close();
           }
        return funcionarios;
    }
    @Deprecated
    public static Locatario obterLocatario(long id) throws SQLException, ResultSetNuloOuVazioException, EntidadeDesconhecidaExeption{
        Locatario locatario= null;
        PreparedStatement pstmt = Conector.getConexao().prepareStatement("select * from pessoa where id = ?;");
        pstmt.setLong(1, id);
        try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                   
                   String nome = (rs.getString("nome"));
                   String rua = (rs.getString("rua"));
                   int numero = (rs.getInt("numero"));
                   String cep = (rs.getString("cep"));
                   String bairro = (rs.getString("bairro"));
                   String cidade = (rs.getString("cidade"));
                   int tipo = (rs.getInt("tipo"));
                   String cpf = (rs.getString("cpf"));
                   Date dataNascimento = (rs.getDate("dataNascimento"));
                   String razaoSocial = (rs.getString("razaoSocial"));
                   String incricaoEstadual = (rs.getString("incricaoEstadual"));
                   String cnpj = (rs.getString("cnpj"));
                   String uf = (rs.getString("uf"));
                   
                   locatario =  new Locatario();
                    locatario.setId(id);
                    locatario.setNome(nome);
                    locatario.setRua(rua);
                    locatario.setNumero(numero);
                    locatario.setCep(cep);
                    locatario.setBairro(bairro);
                    locatario.setCidade(cidade);
                    locatario.setUf(uf);
                    locatario.setTipo(TipoLocatario.values()[tipo]);
                    locatario.setCnpj(cnpj);
                    locatario.setInscricaoEstadual(incricaoEstadual);
                    locatario.setRazaoSocial(razaoSocial);
                   
                    locatario.setCpf(cpf);
                    locatario.setDataNascimento(dataNascimento);
                    
                   
                }
                rs.close();
           } 
        return locatario;
    }
    @Deprecated
    public static List<Locatario> obterLocatarios() throws SQLException, ResultSetNuloOuVazioException, EntidadeDesconhecidaExeption{
        List<Locatario> locatarios = new ArrayList();
        try(ResultSet rs = Conector.obterDados("select * from pessoa;")){
                while(rs.next()){
                   long id = (rs.getLong("id"));
                   String nome = (rs.getString("nome"));
                   String rua = (rs.getString("rua"));
                   int numero = (rs.getInt("numero"));
                   String cep = (rs.getString("cep"));
                   String bairro = (rs.getString("bairro"));
                   String cidade = (rs.getString("cidade"));
                   int tipo = (rs.getInt("tipo"));
                   String cpf = (rs.getString("cpf"));
                   Date dataNascimento = (rs.getDate("dataNascimento"));
                   String razaoSocial = (rs.getString("razaoSocial"));
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
                    locatario.setTipo(TipoLocatario.values()[tipo]);
                    locatario.setCnpj(cnpj);
                    locatario.setInscricaoEstadual(incricaoEstadual);
                    locatario.setRazaoSocial(razaoSocial);
                   
                    locatario.setCpf(cpf);
                    locatario.setDataNascimento(dataNascimento);
                    
                   locatarios.add(locatario);
                }
                rs.close();
           } 
        return locatarios;
    }
    
}

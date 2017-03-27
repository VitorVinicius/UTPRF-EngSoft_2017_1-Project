/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Excecoes.ParametrosInsuficientesException;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vitor
 */
public class Conector {
    private static Connection conexao;
    public static Connection getConexao() throws SQLException{
        if(conexao==null)
            conexao = DBConnectionManager.getConnection();
        return conexao;
    }
    
    /**
     * @param dbServer endereço do servidor MySQL
     * @param dbServerPort porta do servidor MySQL
     * @param dataBase nome do banco de dados
     * @param userName nome de usuário do banco de dados
     * @param password senha de usuário do banco de dados
     * @throws Excecoes.ParametrosInsuficientesException
     * @throws java.sql.SQLException
     */
    
    public static void conectar(String dbServer, int dbServerPort, String dataBase,String userName,String password) throws ParametrosInsuficientesException, SQLException{
        DBConnectionManager.configurar(dbServer, dbServerPort, dataBase, userName, password);
        getConexao();
    }
    public static void fecharConexao() throws SQLException{
     if(conexao!=null)   
         conexao.close();
    }
    public static void executarConsulta(String consulta) throws SQLException{
        
           try( Statement stmt = getConexao().createStatement()){
                stmt.executeUpdate(consulta);
                stmt.close();
            }
    }
    public static ResultSet  obterDados(String consulta) throws SQLException, ResultSetNuloOuVazioException{
        ResultSet resultSet;
        
        Statement stmt = getConexao().createStatement();
        resultSet = stmt.executeQuery(consulta);
            
        if(resultSet == null){
            throw new Excecoes.ResultSetNuloOuVazioException("O conjunto de dados resultante da consulta '"+  consulta +"' retornou vazio após o envio ao banco de dados");
        }
        return resultSet;
    }
}

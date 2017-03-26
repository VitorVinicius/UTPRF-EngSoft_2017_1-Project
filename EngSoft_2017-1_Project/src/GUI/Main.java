/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Locatario;
import Classes.Pessoa;
import Classes.PessoaFisica;
import Classes.PessoaJuridica;
import Database.Conector;

import Database.Conector;
import Excecoes.ParametrosInsuficientesException;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Excecoes.ConfiguracoesException;
import Excecoes.EntidadeDesconhecidaExeption;
import Excecoes.ParametrosInsuficientesException;
import Excecoes.ResultSetNuloOuVazioException;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParametrosInsuficientesException {
        try {
           Database.Conector.conectar("localhost", 3306, "locadora", "root", "root");
           try(ResultSet rs = Conector.obterDados("select * from funcionario;")){
                while(rs.next()){
                    String coluna = (rs.getString("id"));
                    System.out.println(coluna);
                }
                rs.close();
           }
           Database.Conector.fecharConexao();
        } catch (SQLException | ResultSetNuloOuVazioException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}

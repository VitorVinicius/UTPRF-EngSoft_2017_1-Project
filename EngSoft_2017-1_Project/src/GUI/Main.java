/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Funcionario;

import Database.Conector;
import Database.Propiedades;
import Excecoes.ConfiguracoesException;
import Excecoes.ParametrosInsuficientesException;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //Instanciei um funcionario pra interação com a interface e métodos. Futuro sistema de login
    private static Funcionario funcionario;

    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario funcionario) {
        Main.funcionario = funcionario;
    }
    private static int falhasConexao= 0;
    public static void main(String[] args) throws ParametrosInsuficientesException {
        
        if(!Propiedades.checarArquivoExiste()){
             new TelaConfigurarBD(null, true).setVisible(true);
        }
        
        try {
           Database.Conector.conectar(Propiedades.getPropiedade("dbServer"), Integer.parseInt(Propiedades.getPropiedade("dbServerPort")) , Propiedades.getPropiedade("dataBase"), Propiedades.getPropiedade("userName"), Propiedades.getPropiedade("password"));
           try(ResultSet rs = Conector.obterDados("select * from funcionario;")){
                while(rs.next()){
                    funcionario = new Funcionario();
                    long id = (rs.getLong("id"));
                    funcionario = new Funcionario();
                    funcionario.setId(id);
                    //terminar de settar atributos
                }
                rs.close();
           }
           catch (ResultSetNuloOuVazioException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
           if(funcionario!=null){
               new TelaPrincipal().setVisible(true);
           }else{
               funcionario= new Funcionario();
               funcionario.setId(1);
               new TelaPrincipal().setVisible(true);
               JOptionPane.showMessageDialog(null, "Não existem funcionários cadastrados. Cadastre um para abrir o aplicativo.", "Nenhum funcionáio", JOptionPane.ERROR_MESSAGE);
           }
           
           
        } catch (SQLException ex){
            
            new TelaConfigurarBD(null, true).setVisible(true);
            try {
                Conector.fecharConexao();
            } catch (SQLException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
            if(falhasConexao++ <3){
                main( new String[]{} );
            }else{
                System.exit(-1);
            }
         } 
        catch (ConfiguracoesException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        }

    }


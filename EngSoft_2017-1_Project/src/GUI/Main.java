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
    public static void main(String[] args) {
        try {
           
            if(!Database.Propiedades.checarArquivoExiste()){
                TelaConfigurarBD telaCfg = new TelaConfigurarBD((Frame)null,true);    
                telaCfg.setVisible(true);
                boolean configurado = telaCfg.foiConfigurado();
                if(!configurado){
                    System.exit(-1);
                }
                
            }else{
               Database.Propiedades.carregarOuGerarArquivo();
            }
           //Database.Propiedades.carregarOuGerarArquivo();
           
           String dbServer = Database.Propiedades.getPropiedade("dbServer");
           String dbServerPort = Database.Propiedades.getPropiedade("dbServerPort");
           String dataBase = Database.Propiedades.getPropiedade("dataBase");
           String userName = Database.Propiedades.getPropiedade("userName");
           String password = Database.Propiedades.getPropiedade("password");
           
           Database.Conector.conectar(dbServer, Integer.parseInt(dbServerPort), dataBase, userName, password);
           
           //Exemplo para obter todos os Locatarios
            List<Locatario> locatarios = Database.Entidades.obterLocatarios();
            PessoaFisica primeiraPessoa = (PessoaFisica)locatarios.get(0);//casting para pessoa. Poderia ser casting para PessoaFisica ou PessoaJuridica tbm
            JOptionPane.showMessageDialog(null, locatarios.size() + " locatários encontrados. Primeiro: "+primeiraPessoa.getNome());
           //fim do exemplo
           Database.Conector.fecharConexao();
        } catch (SQLException | ParametrosInsuficientesException | ConfiguracoesException | ResultSetNuloOuVazioException | EntidadeDesconhecidaExeption ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

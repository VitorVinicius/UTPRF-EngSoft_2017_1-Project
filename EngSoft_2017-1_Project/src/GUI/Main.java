/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Funcionario;

import Database.Persistencia;
import java.awt.Frame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
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
    public static void main(String[] args)  {
         
         
        try {
            Persistencia.estabelecerConexao();
            
            Query query = Persistencia.getManager().createQuery("select count(*) from Funcionario as t");
           
            long contagem = (long) query.getSingleResult();
            
            if(contagem==0){
              JOptionPane.showMessageDialog(null, "Cadastre um funcionario para continuar.", "Nenhum Funcionario Presente", JOptionPane.INFORMATION_MESSAGE);
              TelaCadastroCliente telaCadastro = new TelaCadastroCliente((Frame)null,true);
              telaCadastro.setLogarFuncionarioAoCadastrar(true);
              telaCadastro.setVisible(true);
            }else{
                new TelaLogin().setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    
    }

    }


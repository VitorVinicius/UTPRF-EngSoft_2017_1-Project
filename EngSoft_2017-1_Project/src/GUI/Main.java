/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Funcionario;

import Database.Persistencia;
import Excecoes.ParametrosInsuficientesException;
import java.awt.Frame;
import java.util.List;
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
         
         
        try {
            Persistencia.estabelecerConexao();
            List<Object> funcionarios =  Persistencia.buscar("select t from Locatario as t where DTYPE = 'Funcionario'");
            if(funcionarios!=null && !funcionarios.isEmpty()){
                funcionario =(Funcionario) funcionarios.get(0);
            }
            else{
              JOptionPane.showMessageDialog(null, "Cadastre um funcionario para continuar.", "Nenhum Funcionario Presente", JOptionPane.INFORMATION_MESSAGE);
              TelaCadastroCliente telaCadastro = new TelaCadastroCliente((Frame)null,true);
              telaCadastro.setLogarFuncionarioAoCadastrar(true);
              telaCadastro.setVisible(true);
              
                
            }
            if(funcionario!=null){
               new TelaPrincipal().setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    
    }

    }


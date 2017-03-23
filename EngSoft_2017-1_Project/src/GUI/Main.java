/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.Conector;
import Excecoes.ParametrosInsuficientesException;
import Excecoes.ResultSetNuloOuVazioException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
           Database.Conector.Conectar("localhost", 3306, "nome_do_banco", "usuario", "senha");
           try(ResultSet rs = Conector.obterDados("select * from nome_da_tabela;")){
                while(rs.next()){
                    String coluna = (rs.getString("nome_da_coluna"));
                    System.out.println(coluna);
                }
                rs.close();
           }
           Database.Conector.fecharConexao();
        } catch (SQLException | ResultSetNuloOuVazioException | ParametrosInsuficientesException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

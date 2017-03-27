/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * Esta classe foi baseada em um código existente na URL: http://stackoverflow.com/questions/12176277/best-way-for-creating-database-connections
 * de autoria do usuário 'brainless' do fórum stackoverflow e precisa ser testado.
 * 
 */

import Excecoes.ParametrosInsuficientesException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author brainless
*/
public class DBConnectionManager {

    private static String dataBase;
    private static String userName;
    private static String password;
    private static String dbURL;
    private static String dbServer;
    private static int dbServerPort;



protected static void configurar(String dbServer, int dbServerPort, String dataBase,String userName,String password) throws ParametrosInsuficientesException {
        DBConnectionManager.dataBase = dataBase;
        DBConnectionManager.userName = userName;
        DBConnectionManager.password = password;
        DBConnectionManager.dbServer = dbServer;
        DBConnectionManager.dbServerPort= dbServerPort;
    if(
          dbServerPort>0
          &&   dbServer!= null && !dbServer.isEmpty()
          &&   dataBase!= null && !dataBase.isEmpty()
          &&   userName!= null && !userName.isEmpty()
          &&   password!= null && !password.isEmpty()
    ){
        dbURL = "jdbc:mysql://"+
                DBConnectionManager.dbServer
                +":"+
                DBConnectionManager.dbServerPort
                +"/"
                + DBConnectionManager.dataBase +"?useUnicode=true&useEncoding=true&characterEncoding=UTF-8";
    }
    else{
        throw new Excecoes.ParametrosInsuficientesException("A quantidade de parâmetros informados para configurar o "
        +" conector do banco de dados é insuficiente.");
    }
}

    protected static Connection getConnection() throws SQLException {
        
            return DriverManager.getConnection(
          dbURL, userName, password);
        
    }

}

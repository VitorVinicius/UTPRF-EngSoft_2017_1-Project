/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vitor
 */
public class Persistencia {
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private static boolean conexaoEstabelecida = false;
    public static EntityManager getManager() {
        return manager;
    }

    public static void estabelecerConexao() throws Exception{
        if(conexaoEstabelecida) throw new Exception("A conexão com o banco de dados já foi estabelecida.");
        
        factory = Persistence.createEntityManagerFactory("locadora");
        manager = factory.createEntityManager();
        conexaoEstabelecida = true;
    }
    public static Object salvar(Object objeto) throws Exception{
         if(!conexaoEstabelecida) throw new Exception("A conexão com o banco de dados não foi estabelecida ainda.");
        
         manager.getTransaction().begin();
         manager.persist(objeto);
         manager.flush();
         manager.getTransaction().commit();
         return objeto;
    }
    public static void atualizar(Object objeto) throws Exception{
         if(!conexaoEstabelecida) throw new Exception("A conexão com o banco de dados não foi estabelecida ainda.");
        
         manager.getTransaction().begin();
         manager.merge(objeto);
         manager.getTransaction().commit();
    }
    public static void remover(Object objeto) throws Exception{
         if(!conexaoEstabelecida) throw new Exception("A conexão com o banco de dados não foi estabelecida ainda.");
        
         manager.getTransaction().begin();
         manager.remove(objeto);
         manager.getTransaction().commit();
    }
    public static Object buscar( Class tipo,long id) throws Exception{
         if(!conexaoEstabelecida) throw new Exception("A conexão com o banco de dados não foi estabelecida ainda.");
        
        Object encontrado = manager.find(tipo, id);
        return encontrado;
    }
    public static List<Object> buscar( String consulta) throws Exception{
         if(!conexaoEstabelecida) throw new Exception("A conexão com o banco de dados não foi estabelecida ainda.");
        
        List<Object> encontrados = manager.createQuery(consulta).getResultList();
        return encontrados;
    }
    public static void encerrarConexao() throws Exception{
         if(!conexaoEstabelecida) throw new Exception("A conexão com o banco de dados não foi estabelecida ainda.");
        
        manager.close();
        factory.close();
    }
}

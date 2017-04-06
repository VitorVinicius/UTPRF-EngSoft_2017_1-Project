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
    public static EntityManager getManager() {
        return manager;
    }

    public static void estabelecerConexao() throws Exception{
        factory = Persistence.createEntityManagerFactory("locadora");
        manager = factory.createEntityManager();
    }
    public static Object salvar(Object objeto) throws Exception{
         manager.getTransaction().begin();
         manager.persist(objeto);
         manager.flush();
         manager.getTransaction().commit();
         return objeto;
    }
    public static void atualizar(Object objeto) throws Exception{
         manager.getTransaction().begin();
         manager.merge(objeto);
         manager.getTransaction().commit();
    }
    public static void remover(Object objeto) throws Exception{
         manager.getTransaction().begin();
         manager.remove(objeto);
         manager.getTransaction().commit();
    }
    public static Object buscar( Class tipo,long id) throws Exception{
        Object encontrado = manager.find(tipo, id);
        return encontrado;
    }
    public static List<Object> buscar( String consulta) throws Exception{
        List<Object> encontrados = manager.createQuery(consulta).getResultList();
        return encontrados;
    }
    public static void encerrarConexao() throws Exception{
        manager.close();
        factory.close();
    }
}

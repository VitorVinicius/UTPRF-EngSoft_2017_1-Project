/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import GUI.Main;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vitor
 */
public final class Persistencia {
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
         try {
            getManager().getTransaction().begin();
            getManager().persist(objeto);
            getManager().flush();
            getManager().getTransaction().commit();
        } catch (Exception ex) {
            if(getManager().getTransaction().isActive())
                getManager().getTransaction().rollback();
            throw ex;
        }
        return objeto;
    }
    public static void atualizar(Object objeto) throws Exception{
        try {
            getManager().getTransaction().begin();
            getManager().merge(objeto);
            getManager().getTransaction().commit();
        } catch (Exception ex) {
            if(getManager().getTransaction().isActive())
                getManager().getTransaction().rollback();
            throw ex;
        }
    }
    public static void detach(Object obj){
        try{
            getManager().detach(obj);
        }
        catch(Exception ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void remover(Object objeto) throws Exception{
        try {
            getManager().getTransaction().begin();
            getManager().remove(objeto);
            getManager().getTransaction().commit();
        } catch (Exception ex) {
            if(getManager().getTransaction().isActive())
                getManager().getTransaction().rollback();
            throw ex;
        }
    }
    public static Object buscar( Class tipo,long id) throws Exception{
        Object encontrado = getManager().find(tipo, id);
        return encontrado;
    }
    public static List<Object> buscar( String consulta) throws Exception{
        List<Object> encontrados = getManager().createQuery(consulta).getResultList();
        return encontrados;
    }
    public static void encerrarConexao() throws Exception{
        getManager().close();
        factory.close();
    }

    public static List<Object> buscar(String consulta, int limite) {
        Query query = getManager().createQuery(consulta);
        query.setMaxResults(limite);
        List<Object> encontrados = query.getResultList();
        return encontrados;
    }
    public static List<Object> buscar(Query query ) {
        List<Object> encontrados = query.getResultList();
        return encontrados;
    }
}

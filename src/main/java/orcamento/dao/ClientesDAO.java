package orcamento.dao;

import orcamento.bean.ClienteBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class ClientesDAO {


    public void createCliente(ClienteBean clienteBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(clienteBean);
        manager.getTransaction().commit();

        factory.close();
    }

    public ArrayList<ClienteBean> listClientes(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT s FROM ClienteBean s" ) ;
        List<ClienteBean> listCliente = query.getResultList();

        factory.close();
        return (ArrayList) listCliente;
    }

    public void deleteCliente(String codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(ClienteBean.class, codigo));
        manager.getTransaction().commit();

        factory.close();
    }

}

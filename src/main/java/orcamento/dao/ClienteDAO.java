package orcamento.dao;

import orcamento.bean.ClienteBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mgustavo on 09/12/15.
 */
public class ClienteDAO {

    public ClienteBean getCliente() {
        ClienteBean clienteBean = new ClienteBean();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();
/*        manager.getTransaction().begin();
        manager.getTransaction().commit();*/
        factory.close();

        return clienteBean;
    }

}

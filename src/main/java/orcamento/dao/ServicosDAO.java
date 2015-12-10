package orcamento.dao;

import orcamento.bean.ServicoBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class ServicosDAO {


    public void createServico(ServicoBean servicoBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(servicoBean);
        manager.getTransaction().commit();

        factory.close();
    }

    public ArrayList<ServicoBean> listServicos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT s FROM ServicoBean s" ) ;
        List<ServicoBean> listServico = query.getResultList();

        factory.close();
        return (ArrayList) listServico;
    }

    public void deleteServico(String codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(ServicoBean.class, codigo));
        manager.getTransaction().commit();

        factory.close();
    }

}

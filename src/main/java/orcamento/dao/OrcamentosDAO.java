package orcamento.dao;

import orcamento.bean.OrcamentoBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class OrcamentosDAO {


    public OrcamentoBean createOrcamento(OrcamentoBean orcamentoBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(orcamentoBean);
        manager.getTransaction().commit();

        factory.close();
        return orcamentoBean;
    }

    public Collection<OrcamentoBean> listOrcamentos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT s FROM OrcamentoBean s" ) ;
        List<OrcamentoBean> listOrcamento = query.getResultList();

        factory.close();
        return listOrcamento;
    }

    public void deleteOrcamento(String codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(OrcamentoBean.class, codigo));
        manager.getTransaction().commit();

        factory.close();
    }

}

package orcamento.dao;

import orcamento.bean.MedicoBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class MedicosDAO {


    public void createMedico(MedicoBean medicoBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(medicoBean);
        manager.getTransaction().commit();

        factory.close();
    }

    public ArrayList<MedicoBean> listMedicos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT s FROM MedicoBean s" ) ;
        List<MedicoBean> listMedico = query.getResultList();

        factory.close();
        return (ArrayList) listMedico;
    }

    public void deleteMedico(String codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(MedicoBean.class, codigo));
        manager.getTransaction().commit();

        factory.close();
    }

}

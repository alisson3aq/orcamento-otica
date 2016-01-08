package orcamento.dao;

import orcamento.bean.OrcamentoBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class OrcamentosDAO {


    public OrcamentoBean createOrcamento(OrcamentoBean orcamentoBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(orcamentoBean.getDataorcamento());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        orcamentoBean.setDataorcamento(calendar.getTime());

        calendar.setTime(orcamentoBean.getDataentrega());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        orcamentoBean.setDataentrega(calendar.getTime());

        manager.getTransaction().begin();
        manager.persist(orcamentoBean);
        manager.getTransaction().commit();

        factory.close();
        return orcamentoBean;
    }

    public OrcamentoBean readOrcamento(Long codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        OrcamentoBean orcamentoBean = manager.find(OrcamentoBean.class,codigo);

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


    public Collection<OrcamentoBean> listOrcamentos(Date from, Date to){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        from =  calendar.getTime();

        calendar.setTime(to);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        to =  calendar.getTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String frmDate = format.format(from);
        String enDate = format.format(to);

        Query query = manager.createQuery("SELECT s FROM OrcamentoBean s WHERE s.dataorcamento BETWEEN '" + frmDate  + "' AND '" + enDate + "'");
        List<OrcamentoBean> listOrcamento = query.getResultList();

        factory.close();
        return listOrcamento;
    }

    public void deleteOrcamento(Long codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(OrcamentoBean.class, codigo));
        manager.getTransaction().commit();

        factory.close();
    }

}

package orcamento.dao;

import orcamento.bean.EmpresaBean;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class EmpresasDAO {


    public void createEmpresa(EmpresaBean empresaBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(empresaBean);
        manager.getTransaction().commit();

        factory.close();
    }

    public ArrayList<EmpresaBean> listEmpresas(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT p FROM EmpresaBean p" ) ;
        List<EmpresaBean> listEmpresa = query.getResultList();

        factory.close();
        return (ArrayList) listEmpresa;
    }

    public void deleteEmpresa(String codigo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(EmpresaBean.class, codigo));
        manager.getTransaction().commit();

        factory.close();
    }


    public EmpresaBean updateEmpresa(EmpresaBean empresaBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();
        final EmpresaBean empresaBean1;
        if(empresaBean.getId() != null) {
            manager.getTransaction().begin();
            empresaBean1 = manager.find(EmpresaBean.class, empresaBean.getId());
            empresaBean1.setBairro(empresaBean.getBairro());
            empresaBean1.setCep(empresaBean.getCep());
            empresaBean1.setCidade(empresaBean.getCidade());
            empresaBean1.setCnpj(empresaBean.getCnpj());
            empresaBean1.setEmail(empresaBean.getEmail());
            empresaBean1.setEndereco(empresaBean.getEndereco());
            empresaBean1.setEstado(empresaBean.getEstado());
            empresaBean1.setNome(empresaBean.getNome());
            empresaBean1.setTelefone(empresaBean.getTelefone());
            manager.getTransaction().commit();
            factory.close();
            return empresaBean1;

        }else{
            createEmpresa(empresaBean);
        }

        return empresaBean;
    }

}

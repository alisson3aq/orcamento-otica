package orcamento.dao;

import orcamento.bean.EmpresaBean;
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

        EmpresaBean emp = manager.find(EmpresaBean.class,empresaBean.getCnpj());

        if(emp != null) {
            manager.getTransaction().begin();
            emp.setTelefone(empresaBean.getTelefone());
            emp.setEstado(empresaBean.getEstado());
            emp.setNome(empresaBean.getNome());
            emp.setEndereco(empresaBean.getEndereco());
            emp.setBairro(empresaBean.getBairro());
            emp.setCep(empresaBean.getCep());
            emp.setCidade(empresaBean.getCidade());
            emp.setEmail(empresaBean.getEmail());
            manager.persist(emp);
            manager.getTransaction().commit();
            factory.close();
            return emp;
        }else {
            createEmpresa(empresaBean);
            return empresaBean;
        }
    }

}

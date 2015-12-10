package orcamento.dao;

import orcamento.bean.ProdutoBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class ProdutosDAO {


    public void createProduto(ProdutoBean produtoBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(produtoBean);
        manager.getTransaction().commit();

        factory.close();
    }

    public ArrayList<ProdutoBean> listProdutos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT p FROM ProdutoBean p" ) ;
        List<ProdutoBean> listProduto = query.getResultList();

        factory.close();
        return (ArrayList) listProduto;
    }

    public void deleteProduto(String cpf){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(ProdutoBean.class, cpf));
        manager.getTransaction().commit();

        factory.close();
    }

}

package orcamento.dao;

import orcamento.bean.UsuarioBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgustavo on 09/12/15.
 */
public class UsuariosDAO {


    public void createUsuario(UsuarioBean usuarioBean){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(usuarioBean);
        manager.getTransaction().commit();

        factory.close();
    }

    public ArrayList<UsuarioBean> listUsuarios(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT u FROM UsuarioBean u" ) ;
        List<UsuarioBean> listUsuario = query.getResultList();

        factory.close();
        return (ArrayList) listUsuario;
    }

    public UsuarioBean getUsuarioByLogin(String login) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT u FROM UsuarioBean u WHERE u.login = '" + login + "'");
        UsuarioBean usuario = (UsuarioBean) query.getSingleResult();
        return usuario;
    }

    public void deleteUsuario(String login){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.remove(manager.getReference(UsuarioBean.class, login));
        manager.getTransaction().commit();

        factory.close();
    }

}

package orcamento.service.impl;

import orcamento.bean.UsuarioBean;
import orcamento.dao.UsuariosDAO;
import orcamento.service.IUsuariosService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class UsuariosService implements IUsuariosService {

    @Override
    public ArrayList<UsuarioBean> listUsuarios() {

        UsuariosDAO usuariosDAO = new UsuariosDAO();

        return usuariosDAO.listUsuarios();
    }

    @Override
    public UsuarioBean getUsuario(String chavePrimaria) {

        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setLogin("matheusct");
        usuarioBean.setNome("Matheus Cavalcante Teixeira");


        return usuarioBean;
    }

    @Override
    public Boolean createUsuario(UsuarioBean usuarioBean) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.createUsuario(usuarioBean);
        return true;
    }

    @Override
    public Boolean updateUsuario(UsuarioBean usuarioBean) {
        return true;
    }

    @Override
    public Boolean deleteUsuario(String login) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.deleteUsuario(login);
        return true;
    }
}

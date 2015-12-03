package orcamento.service.impl;

import orcamento.bean.UsuarioBean;
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
        ArrayList<UsuarioBean> usuarioBeans = new ArrayList<UsuarioBean>();

        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setLogin("matheusct");
        usuarioBean.setNome("Matheus Cavalcante Teixeira");

        UsuarioBean usuarioBean1 = new UsuarioBean();
        usuarioBean1.setLogin("mgustavo");
        usuarioBean1.setNome("Matheus Gustavo Pereira de Oliveira");

        UsuarioBean usuarioBean2 = new UsuarioBean();
        usuarioBean2.setLogin("pedroh");
        usuarioBean2.setNome("Pedro Henrique Almeida");

        usuarioBeans.add(usuarioBean);
        usuarioBeans.add(usuarioBean1);
        usuarioBeans.add(usuarioBean2);

        return usuarioBeans;
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
        return true;
    }

    @Override
    public Boolean updateUsuario(UsuarioBean usuarioBean) {
        return true;
    }

    @Override
    public Boolean deleteUsuario(String chavePrimaria) {
        return true;
    }
}

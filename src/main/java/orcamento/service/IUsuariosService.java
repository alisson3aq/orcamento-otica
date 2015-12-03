package orcamento.service;

import orcamento.bean.UsuarioBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IUsuariosService {
    ArrayList<UsuarioBean> listOrcamento();

    UsuarioBean getUsuario(String chavePrimaria);

    Boolean createUsuario(UsuarioBean usuarioBean);

    Boolean updateUsuario(UsuarioBean usuarioBean);

    Boolean deleteUsuario(String chavePrimaria);
}

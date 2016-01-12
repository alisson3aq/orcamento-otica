package orcamento.controller;

import orcamento.bean.UsuarioBean;
import orcamento.service.impl.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/seguranca")
public class SegurancaController {

    @Autowired
    UsuariosService usuariosService;

    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    @ResponseBody
    public Boolean autenticar(@RequestBody UsuarioBean usuarioBean) {
        if (usuarioBean != null && usuarioBean.getLogin() != null && usuarioBean.getSenha() != null) {
            UsuarioBean usuario = usuariosService.getUsuarioByLogin(usuarioBean.getLogin());
            if (usuario != null && usuario.getSenha().equals(usuarioBean.getSenha())) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}

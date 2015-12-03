package orcamento.controller;

import orcamento.bean.UsuarioBean;
import orcamento.service.impl.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<UsuarioBean> listUsuarios(){
		return usuariosService.listUsuarios();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postUsuarios(@RequestBody UsuarioBean usuarioBean){
		return usuariosService.createUsuario(usuarioBean);
	}
	
}

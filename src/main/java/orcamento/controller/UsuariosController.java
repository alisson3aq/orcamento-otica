package orcamento.controller;

import orcamento.bean.UsuarioBean;
import orcamento.service.impl.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	public ArrayList<UsuarioBean> postUsuarios(@RequestBody UsuarioBean usuarioBean){
		System.out.println(usuarioBean);
		usuariosService.createUsuario(usuarioBean);
		return usuariosService.listUsuarios();
	}


	@RequestMapping(value = " /{login}",method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<UsuarioBean> deleteUsuario(@PathVariable String login){
		usuariosService.deleteUsuario(login);
		return usuariosService.listUsuarios();
	}
	
}

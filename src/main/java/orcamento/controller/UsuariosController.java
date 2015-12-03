package orcamento.controller;

import orcamento.bean.UsuarioBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<UsuarioBean> listUsuarios(){
		return new ArrayList<UsuarioBean>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postUsuarios(@RequestBody UsuarioBean usuarioBean){
		return false;
	}
	
}

package orcamento.controller;

import orcamento.bean.ClienteBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ClienteBean> listCliente(){
		return new ArrayList<ClienteBean>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postCliente(RequestBody ClienteBean){
		return false;
	}
	
}

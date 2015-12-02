package orcamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Boolean getCliente(){	
		return false;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postCliente(){	
		return false;
	}
	
}

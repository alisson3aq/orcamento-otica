package orcamento.controller;

import orcamento.bean.ClienteBean;
import orcamento.service.impl.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	ClientesService clientesService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ClienteBean> listCliente(){
		return clientesService.listClientes();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<ClienteBean> postCliente(@RequestBody ClienteBean clienteBean){
		clientesService.createCliente(clienteBean);
		return clientesService.listClientes();
	}

	@RequestMapping(value = " /{cpf}",method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<ClienteBean> deleteCliente(@PathVariable String cpf){
		clientesService.deleteCliente(cpf);
		return clientesService.listClientes();
	}

}

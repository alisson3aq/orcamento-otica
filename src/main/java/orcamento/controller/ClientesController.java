package orcamento.controller;

import orcamento.bean.ClienteBean;
import orcamento.service.impl.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	public Boolean postCliente(@RequestBody ClienteBean clienteBean){
		return clientesService.createCliente(clienteBean);
	}
	
}

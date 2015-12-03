package orcamento.controller;

import orcamento.bean.EmpresaBean;
import orcamento.service.impl.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/empresas")
public class EmpresasController {


	@Autowired
	EmpresaService empresaService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<EmpresaBean> listEmpresas(){
		return empresaService.listEmpresas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postEmpresa(@RequestBody EmpresaBean empresaBean){
		return empresaService.createEmpresa(empresaBean);
	}
	
}

package orcamento.controller;

import orcamento.bean.EmpresaBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<EmpresaBean> getEmpresa(){
		return new ArrayList<EmpresaBean>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postEmpresa(@RequestBody EmpresaBean empresaBean){
		return false;
	}
	
}

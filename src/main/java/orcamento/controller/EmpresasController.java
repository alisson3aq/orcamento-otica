package orcamento.controller;

import orcamento.bean.EmpresaBean;
import orcamento.service.impl.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/empresas")
public class EmpresasController {


	@Autowired
	EmpresaService empresaService;
	
	@RequestMapping(value = " /{mockid}",method = RequestMethod.GET)
	@ResponseBody
	public EmpresaBean getEmpresa(@PathVariable String mockid){
		return empresaService.getEmpresa(mockid);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EmpresaBean criarEmpresa(@RequestBody EmpresaBean empresaBean){
		empresaService.createEmpresa(empresaBean);
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public EmpresaBean editarEmpresa(@RequestBody EmpresaBean empresaBean){
		return empresaService.updateEmpresa(empresaBean);
	}

	@RequestMapping(value = " /{cnpj}",method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<EmpresaBean> deleteEmpresa(@PathVariable String cnpj){
		empresaService.deleteEmpresa(cnpj);
		return empresaService.listEmpresas();
	}

}

package orcamento.controller;

import orcamento.bean.OrcamentoBean;
import orcamento.bean.UsuarioBean;
import orcamento.service.impl.OrcamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentosController {

	@Autowired
	OrcamentosService orcamentosService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<OrcamentoBean> listOrcamento(){
		return orcamentosService.listOrcamentos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postOrcamento(@RequestBody OrcamentoBean orcamentoBean){
		return orcamentosService.createOrcamento(orcamentoBean);
	}
	
}

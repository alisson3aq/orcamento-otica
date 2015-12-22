package orcamento.controller;

import orcamento.bean.OrcamentoBean;
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
	public ArrayList<OrcamentoBean> postOrcamento(@RequestBody OrcamentoBean orcamentoBean){
		orcamentosService.createOrcamento(orcamentoBean);
		return orcamentosService.listOrcamentos();
	}
	
}

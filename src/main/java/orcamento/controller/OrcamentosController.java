package orcamento.controller;

import orcamento.bean.OrcamentoBean;
import orcamento.service.impl.OrcamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentosController {

	@Autowired
	OrcamentosService orcamentosService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<OrcamentoBean> listOrcamento(){
		return orcamentosService.listOrcamentos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public OrcamentoBean postOrcamento(@RequestBody OrcamentoBean orcamentoBean){
		return orcamentosService.createOrcamento(orcamentoBean);
	}

	@RequestMapping(value = " /{codigo}",method = RequestMethod.DELETE)
	@ResponseBody
	public Collection<OrcamentoBean> deleteUsuario(@PathVariable String codigo){
		orcamentosService.deleteOrcamento(codigo);
		return orcamentosService.listOrcamentos();
	}
	
}

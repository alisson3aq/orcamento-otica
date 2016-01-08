package orcamento.controller;

import orcamento.bean.OrcamentoBean;
import orcamento.service.impl.OrcamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentosController {

	@Autowired
	OrcamentosService orcamentosService;

	@RequestMapping(value = " /{inicio}/{fim}" ,method = RequestMethod.GET)
	@ResponseBody
	public Collection<OrcamentoBean> listOrcamento(@PathVariable Date inicio, @PathVariable Date fim){
		return orcamentosService.listOrcamentos(inicio,fim);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public OrcamentoBean postOrcamento(@RequestBody OrcamentoBean orcamentoBean){
		return orcamentosService.createOrcamento(orcamentoBean);
	}

	@RequestMapping(value = " /{codigo}",method = RequestMethod.DELETE)
	@ResponseBody
	public Collection<OrcamentoBean> deleteUsuario(@PathVariable String codigo){
		orcamentosService.deleteOrcamento(Long.parseLong(codigo));
		//TODO:retorna lista vazia e chama depois pelo front
		return null;
	}
	
}

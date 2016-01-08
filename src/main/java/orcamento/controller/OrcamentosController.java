package orcamento.controller;

import orcamento.bean.OrcamentoBean;
import orcamento.service.impl.OrcamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentosController {

	@Autowired
	OrcamentosService orcamentosService;

	@RequestMapping(value = " /{inicio}/{fim}" ,method = RequestMethod.GET)
	@ResponseBody
	public Collection<OrcamentoBean> listOrcamento(@PathVariable Long inicio, @PathVariable Long fim){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(inicio));
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		final Date inicioAsDate =  calendar.getTime();

		calendar.setTime(new Date(fim));
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		final Date fimAsDate =  calendar.getTime();

		return orcamentosService.listOrcamentos(inicioAsDate,fimAsDate);
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

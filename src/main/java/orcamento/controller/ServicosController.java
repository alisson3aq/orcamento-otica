package orcamento.controller;

import orcamento.bean.ServicoBean;
import orcamento.service.impl.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
@RequestMapping("/servicos")
public class ServicosController {


	@Autowired
	ServicoService servicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ServicoBean> listServicos(){
		return servicoService.listServicos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postServicos(@RequestBody ServicoBean servicoBean){
		return servicoService.createServico(servicoBean);
	}
	
}

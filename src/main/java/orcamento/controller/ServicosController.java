package orcamento.controller;

import orcamento.bean.ServicoBean;
import orcamento.service.impl.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	public  ArrayList<ServicoBean> postServicos(@RequestBody ServicoBean servicoBean){
		servicoService.createServico(servicoBean);
		return servicoService.listServicos();
	}

	@RequestMapping(value = " /{codigo}",method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<ServicoBean> deleteUsuario(@PathVariable String codigo){
		servicoService.deleteServico(codigo);
		return servicoService.listServicos();
	}

}
